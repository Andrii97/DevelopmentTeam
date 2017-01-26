package ua.training.model.dao.jdbc;

import org.apache.log4j.Logger;
import ua.training.model.dao.GenericDao;
import ua.training.model.dao.exception.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by andrii on 22.01.17.
 */
public abstract class AbstractJdbcDao<E> implements GenericDao<E> {
    protected Connection connection;
    private static Logger logger = Logger.getLogger(AbstractJdbcDao.class);
    public AbstractJdbcDao(Connection connection) {
        this.connection = connection;
    }

    /**
     * SELECT * FROM [Table]
     * @return sql query to retrieve all the records from the database
     */
    protected abstract String getSelectAllQuery();

    /**
     * INSERT INTO [Table] ([column, column, ...]) VALUES (?, ?, ...);
     * @return sql query to insert new records into the database
     */
    protected abstract String getCreateQuery();

    /**
     * UPDATE [Table] SET [column = ?, column = ?, ...] WHERE id = ?;
     * @return sql query to update record in the database
     */
    protected abstract String getUpdateQuery();

    /**
     * DELETE FROM [Table] WHERE id= ?;
     * @return sql query to delete record from the database.
     */
    protected abstract String getDeleteQuery();

    /**
     *
     * @param resultSet
     * @return entity
     * @throws SQLException
     */
    protected abstract E getEntityFromResultSet(ResultSet resultSet) throws SQLException;

    /**
     *
     * @param entity
     * @param id
     */
    protected abstract void setIdForEntity(E entity, int id);

    /**
     *
     * @param query
     * @param entity
     */
    protected abstract void prepareStatementForInsert(PreparedStatement query, E entity) throws SQLException;

    /**
     *
     * @param query
     * @param entity
     */
    protected abstract void prepareStatementForUpdate(PreparedStatement query, E entity) throws SQLException;

    @Override
    public Optional<E> find(Integer id) {
        Optional<E> result = Optional.empty();
        try(PreparedStatement query =
                    connection.prepareStatement(getSelectByIdQuery())){
            query.setInt( 1 , id);
            ResultSet resultSet = query.executeQuery();
            if (resultSet.next()) {
                result = Optional.of(getEntityFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
        return result;
    }

    protected abstract String getSelectByIdQuery();

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
            logger.error(e);
            throw new DaoException(e);
        }
        return result;
    }

    @Override
    public void create(E entity) {
        try( PreparedStatement query =
                     connection.prepareStatement(getCreateQuery(),
                             Statement.RETURN_GENERATED_KEYS ) ){
            prepareStatementForInsert(query, entity);
            query.executeUpdate();
            ResultSet keys =  query.getGeneratedKeys();
            if( keys.next()){
                setIdForEntity(entity, keys.getInt(1));
            }
        } catch (SQLException e) {
            logger.info(e);
            throw new DaoException(e);
        }
    }

    @Override
    public void update(E entity) {
        try (PreparedStatement query =
                     connection.prepareStatement(getUpdateQuery())) {
            prepareStatementForUpdate(query, entity);
            int count = query.executeUpdate();
            if (count != 1) {
                logger.error("On update modify more then 1 record: " + count);
                throw new DaoException();
            }
        } catch (Exception e) {
            logger.error(e);
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        try (PreparedStatement query =
                     connection.prepareStatement(getDeleteQuery())) {
            query.setInt(1, id);
            query.execute();
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
    }
}
