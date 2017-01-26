package ua.training.model.dao;

import ua.training.model.entity.StatementOfWork;
import ua.training.model.entity.Task;
import ua.training.model.entity.User;

import java.util.List;

/**
 * Created by andrii on 16.01.17.
 */
public interface TaskDao extends GenericDao<Task> {
    List<Task> findByName(String name);
    List<Task> findByStatementOfWork(StatementOfWork statementOfWork);
    List<Task> findByDeveloper(User developer);
}
