package ua.training.model.dao.jdbc;

import org.apache.log4j.Logger;
import ua.training.model.dao.DaoConnection;
import ua.training.model.dao.exception.DaoException;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by andrii on 20.01.17.
 */
public class JdbcDaoConnection implements DaoConnection {
    private static Logger logger = Logger.getLogger(JdbcDaoConnection.class);

    private Connection connection;
    private boolean inTransaction = false;

    public JdbcDaoConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void begin() {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
    }

    @Override
    public void commit() {
        try {
            connection.commit();
            inTransaction = false;
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
    }

    @Override
    public void rollback() {
        try {
            connection.rollback();
            inTransaction = false;
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
    }

    @Override
    public void close() {
        if(inTransaction) {
            rollback();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
    }

    Connection getConnection() {
        return connection;
    }
}
