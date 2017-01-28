package ua.training.model.service;

import org.apache.commons.codec.digest.DigestUtils;
import ua.training.controller.i18n.ErrorsMessages;
import ua.training.model.dao.DaoConnection;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.DeveloperDao;
import ua.training.model.dao.UserDao;
import ua.training.model.entity.Developer;
import ua.training.model.entity.User;
import ua.training.model.service.exception.ServiceException;
import ua.training.utils.constants.LoggerMessages;

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

    public User login(String email, String password){
        String passwordHash = encrypt(password);
        try( DaoConnection connection = daoFactory.getConnection() ){
            UserDao dao = daoFactory.createUserDao(connection);
            return dao.findByEmail(email)
                    .filter(user -> passwordHash.equals(user.getPassword()))
                    .orElseThrow(() -> new ServiceException(
                            ErrorsMessages.SERVICE_ERROR_USER_NOT_FOUND)
                            .addLogMessage(String.format(
                                    LoggerMessages.SERVICE_ERROR_USER_NOT_FOUND,
                                    email, passwordHash)));
        }
    }

    public void create(User user) {
        user.setPassword(encrypt(user.getPassword()));
        try( DaoConnection connection = daoFactory.getConnection() ){
            UserDao dao = daoFactory.createUserDao(connection);
            connection.begin();
            Optional<User> existingUser = dao.findByEmail(user.getEmail());
            checkIfUserAlreadyExist(existingUser);
            dao.create(user);
            connection.commit();
        }
    }

    private String encrypt(String st) {
        return DigestUtils.md5Hex(st);
    }

    private void checkIfUserAlreadyExist(Optional<User> existingUser) {
        existingUser.ifPresent(user -> {throw new ServiceException(
                ErrorsMessages.SERVICE_ERROR_USER_EXIST)
                .addLogMessage(String
                        .format(LoggerMessages.SERVICE_ERROR_USER_EXIST, user.getEmail()));});
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
