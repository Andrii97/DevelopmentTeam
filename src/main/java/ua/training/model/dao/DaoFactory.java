package ua.training.model.dao;

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

//    public abstract DeveloperDao createDeveloperDao();
//    public abstract DeveloperHasTaskDao createDeveloperHasTaskDao();
//    public abstract ProjectDao createProjectDao();
//    public abstract StatementOfWorkDao createStatementOfWorkDao();
//    public abstract TaskDao createTaskDao();
//    public abstract UserDao createUserDao();

    public static final String DB_FILE = "/db.properties";
    private static final String DB_FACTORY_CLASS = "factory.class";
    private static  DaoFactory instance;
    // todo: Holder
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
                throw new RuntimeException(e);
            }
        }
        return instance;
    }
}