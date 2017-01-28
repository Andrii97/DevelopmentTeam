package ua.training.model.dao;

import org.apache.log4j.Logger;
import ua.training.model.dao.exception.DaoException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by andrii on 18.01.17.
 */
public abstract class DaoFactory {

    public abstract DaoConnection getConnection();

    public abstract UserDao createUserDao(DaoConnection daoConnection);
    public abstract StatementOfWorkDao createStatementOfWorkDao(DaoConnection daoConnection);
    public abstract ProjectDao createProjectDao(DaoConnection daoConnection);
    public abstract DeveloperHasTaskDao createDeveloperHasTaskDao(DaoConnection daoConnection);
    public abstract DeveloperDao createDeveloperDao(DaoConnection daoConnection);
    public abstract TaskDao createTaskDao(DaoConnection daoConnection);

    public static final String DB_FILE = "/db.properties";
    private static final String DB_FACTORY_CLASS = "factory.class";
    private static  DaoFactory instance;

    private static Logger logger = Logger.getLogger(DaoFactory.class);

    public static DaoFactory getInstance(){
        if( instance == null) {
            try {
                InputStream inputStream =
                        DaoFactory.class.getResourceAsStream(DB_FILE);
                Properties dbProps = new Properties();
                dbProps.load(inputStream);
                String factoryClass = dbProps.getProperty(DB_FACTORY_CLASS);
                instance = (DaoFactory) Class.forName(factoryClass).newInstance();

            } catch (IOException | IllegalAccessException|
                    InstantiationException |ClassNotFoundException e ) {
                logger.error(e);
                throw new DaoException(e);
            }
        }
        return instance;
    }
}