package ua.training.model.service;

import ua.training.model.dao.DaoConnection;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.DeveloperHasTaskDao;
import ua.training.model.dao.TaskDao;
import ua.training.model.entity.Developer;
import ua.training.model.entity.DeveloperHasTask;
import ua.training.model.entity.Task;
import ua.training.model.entity.User;

import java.util.List;

/**
 * Created by andrii on 23.01.17.
 */
public class TaskService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    private static class Holder{
        static final TaskService INSTANCE = new TaskService();
    }

    public static TaskService getInstance(){
        return Holder.INSTANCE;
    }

    public List<Task> getAll() {
        try( DaoConnection connection = daoFactory.getConnection() ){
            TaskDao dao = daoFactory.createTaskDao(connection);
            return dao.findAll();
        }
    }

    public void create(Task task) {
        try( DaoConnection connection = daoFactory.getConnection() ){
            TaskDao dao = daoFactory.createTaskDao(connection);
            dao.create(task);
        }
    }

    public List<Task> getByDeveloper(User developer) {
        try( DaoConnection connection = daoFactory.getConnection() ){
            TaskDao dao = daoFactory.createTaskDao(connection);
            DeveloperHasTaskDao developerHasTaskDao = daoFactory
                    .createDeveloperHasTaskDao(connection);
            List<Task> result = developerHasTaskDao.findByDeveloperId(developer.getId());
            return result;
        }
    }
}
