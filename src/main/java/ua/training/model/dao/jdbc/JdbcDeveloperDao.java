package ua.training.model.dao.jdbc;

import ua.training.model.dao.DeveloperDao;
import ua.training.model.entity.Developer;
import ua.training.model.entity.Qualification;
import ua.training.model.entity.Role;
import ua.training.model.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrii on 18.01.17.
 */
public class JdbcDeveloperDao implements DeveloperDao {
    private static final String INSERT_INTO_DEVELOPER = "INSERT INTO developer " +
            "(user_id, qualification)" +
            " VALUES (?, ?)";
    private static final String SELECT_FROM_DEVELOPER = "SELECT * from developer" +
            " JOIN user ON developer.user_id = user.id";
    private static final String DELETE_DEVELOPER_BY_USER_ID =
            "DELETE FROM developer WHERE user_id = ?";

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

    private Connection connection;

    public JdbcDeveloperDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Developer find(Integer id) {
        return null;
    }

    @Override
    public List<Developer> findAll() {
        List<Developer> result = new ArrayList<>();
        try(Statement query =
                    connection.createStatement();
            ResultSet resultSet = query.executeQuery(SELECT_FROM_DEVELOPER)){
            while (resultSet.next()) {
                result.add( getDeveloperFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private Developer getDeveloperFromResultSet(ResultSet rs) throws SQLException {
        return new Developer(new User.Builder()
                .setId(rs.getInt(ID))
                .setFirstName(rs.getString(FIRST_NAME))
                .setMiddleName(rs.getString(MIDDLE_NAME))
                .setLastName(rs.getString(LAST_NAME))
                .setEmail(rs.getString(EMAIL))
                .setPassword(rs.getString(PASSWORD))
                .setActive(rs.getBoolean(IS_ACTIVE))
                .setRole(Role.valueOf(rs.getString(ROLE)))
                .build(),
                Qualification.valueOf(rs.getString(QUALIFICATION)),
                rs.getBoolean(IS_FREE));
    }

    @Override
    public void create(Developer entity) {
        try( PreparedStatement query =
                     connection.prepareStatement(INSERT_INTO_DEVELOPER) ){
            query.setInt(1 , entity.getUser().getId());
            query.setString(2 , entity.getQualification().name());
            // query.setBoolean(3 , entity.getFree());

            query.executeUpdate();
            ResultSet keys =  query.getGeneratedKeys();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Developer entity) {

    }

    @Override
    public void delete(Integer id) {
        try (PreparedStatement query =
                     connection.prepareStatement(DELETE_DEVELOPER_BY_USER_ID)) {
            query.setInt(1, id);
            query.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
