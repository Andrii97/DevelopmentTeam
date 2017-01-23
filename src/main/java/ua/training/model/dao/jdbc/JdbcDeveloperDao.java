package ua.training.model.dao.jdbc;

import ua.training.model.dao.DeveloperDao;
import ua.training.model.entity.Developer;
import ua.training.model.entity.Qualification;
import ua.training.model.entity.Role;
import ua.training.model.entity.User;

import java.sql.*;

/**
 * Created by andrii on 18.01.17.
 */
public class JdbcDeveloperDao extends AbstractJdbcDao<Developer> implements DeveloperDao {
    private static final String DELETE_DEVELOPER_BY_USER_ID =
            "DELETE FROM developer WHERE user_id = ? ";
    private static final String INSERT_INTO_DEVELOPER = "INSERT INTO developer " +
            "(user_id, qualification) VALUES (?, ?)  ";
    private static final String SELECT_FROM_DEVELOPER = "SELECT * FROM developer" +
            " JOIN user ON developer.user_id = user.id ";

    private static final String USER_ID = "user_id";
    private static final String QUALIFICATION = "qualification";
    private static final String IS_FREE = "is_free";

    // user
    private static final String ID = "id";
    private static final String FIRST_NAME = "first_name";
    private static final String MIDDLE_NAME = "middle_name";
    private static final String LAST_NAME = "last_name";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String ROLE = "role";
    private static final String IS_ACTIVE = "is_active";

    public JdbcDeveloperDao(Connection connection) {
        super(connection);
    }

    @Override
    protected String getSelectAllQuery() {
        return SELECT_FROM_DEVELOPER;
    }

    @Override
    protected String getCreateQuery() {
        return INSERT_INTO_DEVELOPER;
    }

    @Override
    protected String getUpdateQuery() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected String getDeleteQuery() {
        return DELETE_DEVELOPER_BY_USER_ID;
    }

    @Override
    protected Developer getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        return new Developer(new User.Builder()
                .setId(resultSet.getInt(ID))
                .setFirstName(resultSet.getString(FIRST_NAME))
                .setMiddleName(resultSet.getString(MIDDLE_NAME))
                .setLastName(resultSet.getString(LAST_NAME))
                .setEmail(resultSet.getString(EMAIL))
                .setPassword(resultSet.getString(PASSWORD))
                .setActive(resultSet.getBoolean(IS_ACTIVE))
                .setRole(Role.valueOf(resultSet.getString(ROLE)))
                .build(),
                Qualification.valueOf(resultSet.getString(QUALIFICATION)),
                resultSet.getBoolean(IS_FREE));
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
    protected void prepareStatementForUpdate(PreparedStatement query, Developer entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Developer find(Integer id) {
        return null;
    }

}
