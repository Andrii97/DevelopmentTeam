package ua.training.model.dao.jdbc;

import ua.training.model.dao.UserDao;
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
public class JdbcUserDao implements UserDao {
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
    private Connection connection;

    public JdbcUserDao(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User find(Integer id) {
        try(Statement query =
                    connection.createStatement();
            ResultSet resultSet = query.executeQuery(SELECT_FROM_USER)){
            while (resultSet.next()) {
                //result.add( getUserFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> result = new ArrayList<>();
        try(Statement query =
                    connection.createStatement();
            ResultSet resultSet = query.executeQuery(SELECT_FROM_USER)){
            while (resultSet.next()) {
                result.add( getUserFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public void create(User user) {
        try( PreparedStatement query =
                     connection.prepareStatement(INSERT_INTO_USER
                             , Statement.RETURN_GENERATED_KEYS ) ){
            query.setString(1 , user.getFirstName());
            query.setString(2 , user.getMiddleName());
            query.setString(3 , user.getLastName());
            query.setString(4, user.getEmail());
            query.setString(5, user.getPassword());
            query.setString(6, user.getRole().name());
            // query.setBoolean(7, user.isActive());
            query.executeUpdate();
            ResultSet keys =  query.getGeneratedKeys();
            if( keys.next()){
                user.setId( keys.getInt(1) );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(Integer id) {
        try (PreparedStatement query =
                     connection.prepareStatement(DELETE_USER_BY_ID)) {
            query.setInt(1, id);
            query.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findByName(String name) {
        return null;
    }

    @Override
    public List<User> findByQualification(Qualification qualification) {
        return null;
    }

    private User getUserFromResultSet(ResultSet rs) throws SQLException {
        return new User.Builder()
                .setId(rs.getInt(ID))
                .setFirstName(rs.getString(FIRST_NAME))
                .setMiddleName(rs.getString(MIDDLE_NAME))
                .setLastName(rs.getString(LAST_NAME))
                .setEmail(rs.getString(EMAIL))
                .setPassword(rs.getString(PASSWORD))
                .setActive(rs.getBoolean(IS_ACTIVE))
                .setRole(Role.valueOf(rs.getString(ROLE)))
                .build();
    }

    public Optional<User> findByEmail(String email) {
        Optional<User> result = Optional.empty();

        try(PreparedStatement query =
                    connection.prepareStatement(SELECT_USER_BY_LOGIN) ){
            query.setString( 1, email.toLowerCase());
            ResultSet rs = query.executeQuery();
            if(rs.next()) {
                User user = getUserFromResultSet(rs);
                result = Optional.of(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
