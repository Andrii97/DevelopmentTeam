package ua.training.model.dao.jdbc;

import org.apache.log4j.Logger;
import ua.training.model.dao.*;
import ua.training.model.dao.exception.DaoException;

import java.sql.Connection;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by andrii on 18.01.17.
 */
public class JdbcDaoFactory extends DaoFactory{
    private static Logger logger = Logger.getLogger(JdbcDaoFactory.class);
    private DataSource dataSource;

    public JdbcDaoFactory() {
        try{
            InitialContext ic = new InitialContext();
            dataSource = (DataSource) ic.lookup("java:comp/env/jdbc/development_team");

        }catch(Exception e){
            logger.error(e);
            throw new DaoException(e);
        }
    }

    @Override
    public DaoConnection getConnection() {
        try {
            return new JdbcDaoConnection(dataSource.getConnection());
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
    }

    @Override
    public UserDao createUserDao(DaoConnection daoConnection) {
        JdbcDaoConnection jdbcConnection = (JdbcDaoConnection) daoConnection;
        Connection sqlConnection = jdbcConnection.getConnection();
        return new JdbcUserDao(sqlConnection);
    }

    @Override
    public StatementOfWorkDao createStatementOfWorkDao(DaoConnection daoConnection) {
        JdbcDaoConnection jdbcConnection = (JdbcDaoConnection) daoConnection;
        Connection sqlConnection = jdbcConnection.getConnection();
        return new JdbcStatementOfWorkDao(sqlConnection);
    }

    @Override
    public ProjectDao createProjectDao(DaoConnection daoConnection) {
        JdbcDaoConnection jdbcConnection = (JdbcDaoConnection) daoConnection;
        Connection sqlConnection = jdbcConnection.getConnection();
        return new JdbcProjectDao(sqlConnection);
    }

    @Override
    public DeveloperHasTaskDao createDeveloperHasTaskDao(DaoConnection daoConnection) {
        JdbcDaoConnection jdbcConnection = (JdbcDaoConnection) daoConnection;
        Connection sqlConnection = jdbcConnection.getConnection();
        return new JdbcDeveloperHasTaskDao(sqlConnection);
    }

    @Override
    public DeveloperDao createDeveloperDao(DaoConnection daoConnection) {
        JdbcDaoConnection jdbcConnection = (JdbcDaoConnection) daoConnection;
        Connection sqlConnection = jdbcConnection.getConnection();
        return new JdbcDeveloperDao(sqlConnection);
    }

    @Override
    public TaskDao createTaskDao(DaoConnection daoConnection) {
        JdbcDaoConnection jdbcConnection = (JdbcDaoConnection) daoConnection;
        Connection sqlConnection = jdbcConnection.getConnection();
        return new JdbcTaskDao(sqlConnection);
    }

}
