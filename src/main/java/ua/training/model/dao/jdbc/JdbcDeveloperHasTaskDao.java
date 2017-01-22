package ua.training.model.dao.jdbc;

import ua.training.model.dao.DeveloperHasTaskDao;
import ua.training.model.entity.DeveloperHasTask;

import java.sql.Connection;
import java.util.List;

/**
 * Created by andrii on 20.01.17.
 */
public class JdbcDeveloperHasTaskDao implements DeveloperHasTaskDao {
    private Connection connection;

    public JdbcDeveloperHasTaskDao(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public DeveloperHasTask find(Integer id) {
        return null;
    }

    @Override
    public List<DeveloperHasTask> findAll() {
        return null;
    }

    @Override
    public void create(DeveloperHasTask entity) {

    }

    @Override
    public void update(DeveloperHasTask entity) {

    }

    @Override
    public void delete(Integer id) {

    }
}
