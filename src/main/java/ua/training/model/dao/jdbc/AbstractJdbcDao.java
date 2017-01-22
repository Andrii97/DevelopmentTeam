package ua.training.model.dao.jdbc;

import ua.training.model.dao.GenericDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrii on 22.01.17.
 */
public abstract class AbstractJdbcDao<E> implements GenericDao<E> {
    private Connection connection;
    abstract String getSelectAllQuery();
    abstract E getEntityFromResultSet(ResultSet resultSet);

    // todo?
    @Override
    public E find(Integer id) {
        return null;
    }

    @Override
    public List<E> findAll() {
        List<E> result = new ArrayList<>();
        try(Statement query =
                    connection.createStatement();
            ResultSet resultSet = query.executeQuery(getSelectAllQuery())){
            while (resultSet.next()) {
                result.add( getEntityFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public void create(E e) {

    }

    @Override
    public void update(E e) {

    }

    @Override
    public void delete(Integer id) {

    }
}
