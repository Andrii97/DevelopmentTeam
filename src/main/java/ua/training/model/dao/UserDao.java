package ua.training.model.dao;

import ua.training.model.entity.Qualification;
import ua.training.model.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by andrii on 16.01.17.
 */
public interface UserDao extends GenericDao<User> {
    List<User> findByName(String name);
    List<User> findByQualification(Qualification qualification);
    Optional<User> findByEmail(String email);
}
