package ua.training.model.dao;

import ua.training.model.entity.DeveloperHasTask;

import java.util.List;
import java.util.Optional;

/**
 * Created by andrii on 18.01.17.
 */
public interface DeveloperHasTaskDao extends GenericDao<DeveloperHasTask> {
    List<DeveloperHasTask> findByDeveloperId(Integer id);
    Optional<DeveloperHasTask> findByDeveloperIdAndTaskId(Integer developerId, Integer taskId);
}

