package ua.training.model.dao;

import java.util.List;
import java.util.Optional;

/**
 * Created by andrii on 16.01.17.
 */
public interface GenericDao<E> {
    Optional<E> find(Integer id);
    List<E> findAll();
    void create(E entity);
    void update(E entity);
    void delete(Integer id);
}