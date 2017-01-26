package ua.training.model.service;

import ua.training.model.dao.DaoConnection;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.DeveloperDao;
import ua.training.model.dao.UserDao;
import ua.training.model.entity.Developer;
import ua.training.model.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by andrii on 18.01.17.
 */
public class UserService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    private static class Holder{
        static final UserService INSTANCE = new UserService();
    }

    public static UserService getInstance(){
        return Holder.INSTANCE;
    }

    public Optional<User> login(String email, String password){
        try( DaoConnection connection = daoFactory.getConnection() ){
            UserDao dao = daoFactory.createUserDao(connection);
            return dao.findByEmail(email)
                    .filter(user -> password.equals(user.getPassword()));
        }
    }

    public void create(User user) {
        try( DaoConnection connection = daoFactory.getConnection() ){
            UserDao dao = daoFactory.createUserDao(connection);
            dao.create(user);
        }
    }

    public void createDeveloper(Developer developer) {
        try( DaoConnection connection = daoFactory.getConnection() ){
            connection.begin();
            UserDao userDao = daoFactory.createUserDao(connection);
            DeveloperDao developerDao = daoFactory.createDeveloperDao(connection);
            userDao.create(developer.getUser());
            developerDao.create(developer);
            connection.commit();
        }
    }

    public List<User> getAll() {
        try( DaoConnection connection = daoFactory.getConnection() ){
            UserDao userDao = daoFactory.createUserDao(connection);
            return userDao.findAll();
        }
    }

}
