package ua.training.model.dao;

import java.util.List;

/**
 * Created by andrii on 16.01.17.
 */
public interface GenericDao<E> {
    E find(Integer id);
    List<E> findAll();
    void create(E e);
    void update(E e);
    void delete(Integer id);
}