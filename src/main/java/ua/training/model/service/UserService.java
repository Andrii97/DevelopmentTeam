package ua.training.model.service;

import ua.training.model.dao.DaoConnection;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.UserDao;
import ua.training.model.entity.User;

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
        // ToDo:
        // DaoConnection connection = daoFactory.getConnection();
        // UserDao dao = daoFactory.createUserDao(connection);
        UserDao dao = daoFactory.createUserDao();
        return dao.findByEmail(email)
                .filter(user -> password.equals(user.getPassword()));
    }
}
