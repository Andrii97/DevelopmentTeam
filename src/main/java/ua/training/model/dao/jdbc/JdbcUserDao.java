package ua.training.model.dao.jdbc;

import org.apache.log4j.Logger;
import ua.training.model.dao.UserDao;
import ua.training.model.dao.exception.DaoException;
import ua.training.model.entity.Qualification;
import ua.training.model.entity.Role;
import ua.training.model.entity.User;

import java.sql.*;
import java.util.List;
import java.util.Optional;

/**
 * Created by andrii on 18.01.17.
 */
public class JdbcUserDao extends AbstractJdbcDao<User> implements UserDao {
    private static final String DELETE_USER_BY_ID = "DELETE FROM user WHERE id = ? ";
    private static final String INSERT_INTO_USER = "INSERT INTO user " +
            "(first_name, middle_name, last_name, email, password, role)" +
            " VALUES ( ?, ?, ?, ?, ?, ?) ";
    private static final String SELECT_USER_BY_LOGIN = "SELECT * FROM user WHERE email = ? ";
    private static final String SELECT_FROM_USER = "SELECT * FROM user ";
    private static final String WHERE_ID = "WHERE id = ? ";

    private static final String ID = "user.id";
    private static final String FIRST_NAME = "user.first_name";
    private static final String MIDDLE_NAME = "user.middle_name";
    private static final String LAST_NAME = "user.last_name";
    private static final String EMAIL = "user.email";
    private static final String PASSWORD = "user.password";
    private static final String ROLE = "user.role";
    private static final String IS_ACTIVE = "user.is_active";

    private static Logger logger = Logger.getLogger(JdbcUserDao.class);

    public JdbcUserDao(Connection connection) {
        super(connection);
    }

    @Override
    protected String getSelectAllQuery() {
        return SELECT_FROM_USER;
    }

    @Override
    protected String getCreateQuery() {
        return INSERT_INTO_USER;
    }

    @Override
    protected String getUpdateQuery() {
        throw new UnsupportedOperationException();
    }
    @Override
    protected String getDeleteQuery() {
        return DELETE_USER_BY_ID;
    }

    @Override
    protected User getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        return getUserFromResultSet(resultSet);
    }

    static User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        String role = resultSet.getString(ROLE);
        return new User.Builder()
                .setId(resultSet.getInt(ID))
                .setFirstName(resultSet.getString(FIRST_NAME))
                .setMiddleName(resultSet.getString(MIDDLE_NAME))
                .setLastName(resultSet.getString(LAST_NAME))
                .setEmail(resultSet.getString(EMAIL))
                .setPassword(resultSet.getString(PASSWORD))
                .setActive(resultSet.getBoolean(IS_ACTIVE))
                .setRole(role == null ? null : Role.valueOf(role))
                .build();
    }

    @Override
    protected void setIdForEntity(User entity, int id) {
        entity.setId(id);
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement query, User entity)
            throws SQLException {
        query.setString(1 , entity.getFirstName());
        query.setString(2 , entity.getMiddleName());
        query.setString(3 , entity.getLastName());
        query.setString(4, entity.getEmail());
        query.setString(5, entity.getPassword());
        query.setString(6, entity.getRole().name());
        // query.setBoolean(7, entity.isActive());
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement query, User entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected String getSelectByIdQuery() {
        return SELECT_FROM_USER + WHERE_ID;
    }

    @Override
    public List<User> findByName(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<User> findByQualification(Qualification qualification) {
        throw new UnsupportedOperationException();
    }

    public Optional<User> findByEmail(String email) {
        Optional<User> result = Optional.empty();

        try(PreparedStatement query =
                    connection.prepareStatement(SELECT_USER_BY_LOGIN) ){
            query.setString( 1, email.toLowerCase());
            ResultSet rs = query.executeQuery();
            if(rs.next()) {
                User user = getEntityFromResultSet(rs);
                result = Optional.of(user);
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }

        return result;
    }
}
