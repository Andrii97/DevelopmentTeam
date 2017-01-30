package ua.training.model.dao.jdbc;

import org.apache.log4j.Logger;
import ua.training.model.dao.DeveloperDao;
import ua.training.model.dao.exception.DaoException;
import ua.training.model.entity.Developer;
import ua.training.model.entity.Qualification;
import ua.training.model.entity.Role;
import ua.training.model.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by andrii on 18.01.17.
 */
public class JdbcDeveloperDao extends AbstractJdbcDao<Developer> implements DeveloperDao {
    private static final String DELETE_DEVELOPER_BY_USER_ID =
            "DELETE FROM developer WHERE user_id = ? ";
    private static final String INSERT_INTO_DEVELOPER = "INSERT INTO developer " +
            "(user_id, qualification) VALUES (?, ?)  ";
    private static final String SELECT_FROM_DEVELOPER = "SELECT * FROM developer " +
            "RIGHT JOIN user ON developer.user_id = user.id ";
    private static final String UPDATE_DEVELOPER_BY_USER_ID =
            "UPDATE statement_of_work SET qualification = ?, " +
                    "is_free = ? WHERE id = ? ";
    private static final String WHERE_ROLE_EQUALS_DEVELOPER = "WHERE user.role = 'DEVELOPER' "; // todo
    private static final String WHERE_QUALIFICATION = "WHERE developer.qualification = ? ";
    private static final String WHERE_ID = "WHERE developer.user_id = ? ";

    private static final String USER_ID = "developer.user_id";
    private static final String QUALIFICATION = "developer.qualification";
    private static final String IS_FREE = "developer.is_free";


    private static Logger logger = Logger.getLogger(AbstractJdbcDao.class);

    public JdbcDeveloperDao(Connection connection) {
        super(connection);
    }

    @Override
    protected String getSelectAllQuery() {
        return SELECT_FROM_DEVELOPER + WHERE_ROLE_EQUALS_DEVELOPER;
    }

    @Override
    protected String getCreateQuery() {
        return INSERT_INTO_DEVELOPER;
    }

    @Override
    protected String getUpdateQuery() {
        return UPDATE_DEVELOPER_BY_USER_ID;
    }

    @Override
    protected String getDeleteQuery() {
        return DELETE_DEVELOPER_BY_USER_ID;
    }

    @Override
    protected Developer getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        return getDeveloperFromResultSet(resultSet);
    }

    static Developer getDeveloperFromResultSet(ResultSet resultSet) throws SQLException {
        String qualification = resultSet.getString(QUALIFICATION);
        return new Developer.Builder()
                .setUser(JdbcUserDao.getUserFromResultSet(resultSet))
                .setQualification((qualification == null) ?
                        null : Qualification.valueOf(qualification))
                .setFree(resultSet.getBoolean(IS_FREE))
                .build();
    }

    @Override
    protected void setIdForEntity(Developer entity, int id) {
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement query, Developer entity)
            throws SQLException {
        query.setInt(1 , entity.getUser().getId());
        query.setString(2, entity.getQualification().name());
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement query, Developer entity)
            throws SQLException {
        query.setString(1, entity.getQualification().name());
        query.setBoolean(2, entity.getFree());
        query.setInt(3, entity.getUser().getId());
    }

    @Override
    protected String getSelectByIdQuery() {
        return SELECT_FROM_DEVELOPER + WHERE_ID;
    }

    @Override
    public List<Developer> findByQualification(Qualification qualification) {
        List<Developer> result = new ArrayList<>();
        try(PreparedStatement query =
                connection.prepareStatement(getSelectWhereQualificationQuery())) {
            query.setString(1, qualification.name());
            ResultSet resultSet = query.executeQuery();
            while (resultSet.next()) {
                result.add( getEntityFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
        return result;
    }

    private String getSelectWhereQualificationQuery() {
        return SELECT_FROM_DEVELOPER + WHERE_QUALIFICATION;
    }
}
