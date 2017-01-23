package ua.training.model.dao.jdbc;

import ua.training.model.dao.*;

import java.io.InputStream;
import java.sql.Connection;
//import com.mysql.jdbc.Driver;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by andrii on 18.01.17.
 */
public class JdbcDaoFactory extends DaoFactory{
//    private Connection connection;
    private static final String DB_URL = "url";
    private DataSource dataSource;

    public JdbcDaoFactory() {
        try{
//            InputStream inputStream =
//                    DaoFactory.class.getResourceAsStream(DB_FILE);
//            Properties dbProps = new Properties();
//            dbProps.load(inputStream);
//            new Driver();
//            String url = dbProps.getProperty(DB_URL);
//            connection = DriverManager.getConnection(url , dbProps);
            InitialContext ic = new InitialContext();
            dataSource = (DataSource) ic.lookup("java:comp/env/jdbc/development_team");

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public DaoConnection getConnection() {
        try {
            return new JdbcDaoConnection(dataSource.getConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
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

//    @Override
//    public DeveloperDao createDeveloperDao() {
//        return new JdbcDeveloperDao(connection);
//    }
//
//    @Override
//    public DeveloperHasTaskDao createDeveloperHasTaskDao() {
//        return new JdbcDeveloperHasTaskDao(connection);
//    }
//
//    @Override
//    public ProjectDao createProjectDao() {
//        return new JdbcProjectDao(connection);
//    }
//
//    @Override
//    public StatementOfWorkDao createStatementOfWorkDao() {
//        return new JdbcStatementOfWorkDao(connection);
//    }
//
//    @Override
//    public TaskDao createTaskDao() {
//        return new JdbcTaskDao(connection);
//    }
//
//    @Override
//    public UserDao createUserDao() {
//        return new JdbcUserDao(connection);
//    }

}
