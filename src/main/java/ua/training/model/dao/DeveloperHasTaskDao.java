package ua.training.model.dao;

import ua.training.model.entity.DeveloperHasTask;

import java.util.List;

/**
 * Created by andrii on 18.01.17.
 */
public interface DeveloperHasTaskDao extends GenericDao<DeveloperHasTask> {
    List<DeveloperHasTask> findByDeveloperId(Integer id);
}

