package ua.training.model.dao.jdbc;

import ua.training.model.dao.ProjectDao;
import ua.training.model.entity.Project;

import java.sql.Connection;
import java.util.List;

/**
 * Created by andrii on 20.01.17.
 */
public class JdbcProjectDao implements ProjectDao {
    private static final String SELECT_FROM_PROJECT = "SELECT * FROM project ";
    private Connection connection;

    public JdbcProjectDao(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Project find(Integer id) {
        return null;
    }

    @Override
    public List<Project> findAll() {
        return null;
    }

    @Override
    public void create(Project project) {

    }

    @Override
    public void update(Project project) {

    }

    @Override
    public void delete(Integer id) {

    }
}
