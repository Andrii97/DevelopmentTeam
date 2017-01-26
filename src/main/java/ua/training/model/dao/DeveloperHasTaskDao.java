package ua.training.model.dao;

import ua.training.model.entity.DeveloperHasTask;
import ua.training.model.entity.Task;

import java.util.List;

/**
 * Created by andrii on 18.01.17.
 */
public interface DeveloperHasTaskDao extends GenericDao<DeveloperHasTask> {
    List<Task> findByDeveloperId(Integer id);
}

