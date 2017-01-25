package ua.training.model.dao.jdbc;

import ua.training.model.dao.UserDao;
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

    private static final String ID = "id";
    private static final String FIRST_NAME = "first_name";
    private static final String MIDDLE_NAME = "middle_name";
    private static final String LAST_NAME = "last_name";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String ROLE = "role";
    private static final String IS_ACTIVE = "is_active";

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
        return null;
    }

    @Override
    protected String getDeleteQuery() {
        return DELETE_USER_BY_ID;
    }

    @Override
    protected User getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        return new User.Builder()
                .setId(resultSet.getInt(ID))
                .setFirstName(resultSet.getString(FIRST_NAME))
                .setMiddleName(resultSet.getString(MIDDLE_NAME))
                .setLastName(resultSet.getString(LAST_NAME))
                .setEmail(resultSet.getString(EMAIL))
                .setPassword(resultSet.getString(PASSWORD))
                .setActive(resultSet.getBoolean(IS_ACTIVE))
                .setRole(Role.valueOf(resultSet.getString(ROLE)))
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
        // toDo
    }

    @Override
    protected String getSelectByIdQuery() {
        return SELECT_FROM_USER + WHERE_ID;
    }

    @Override
    public List<User> findByName(String name) {
        return null;
    }

    @Override
    public List<User> findByQualification(Qualification qualification) {
        return null;
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
            throw new RuntimeException(e);
        }

        return result;
    }
}
