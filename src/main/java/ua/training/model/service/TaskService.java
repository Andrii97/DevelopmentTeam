package ua.training.model.service;

import ua.training.model.dao.DaoConnection;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.DeveloperHasTaskDao;
import ua.training.model.dao.TaskDao;
import ua.training.model.entity.*;

import java.util.List;
import java.util.Optional;

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
            connection.begin();
            dao.create(task);
            task.getTaskRequirements().forEach(requirements -> requirements.setTaskId(task.getId()));
            task.getTaskRequirements().forEach(dao::createTaskRequirements);
            connection.commit();
        }
    }

    public List<DeveloperHasTask> getByDeveloper(User developer) {
        try( DaoConnection connection = daoFactory.getConnection() ){
            TaskDao dao = daoFactory.createTaskDao(connection);
            DeveloperHasTaskDao developerHasTaskDao = daoFactory
                    .createDeveloperHasTaskDao(connection);
            List<DeveloperHasTask> result = developerHasTaskDao
                    .findByDeveloperId(developer.getId());
            return result;
        }
    }

    public void createTaskRequirements(TaskRequirements taskRequirements) {
        try( DaoConnection connection = daoFactory.getConnection() ){
            TaskDao dao = daoFactory.createTaskDao(connection);
            dao.createTaskRequirements(taskRequirements);
        }
    }


    public Optional<Task> getById(Integer id) {
        try( DaoConnection connection = daoFactory.getConnection() ){
            TaskDao dao = daoFactory.createTaskDao(connection);
            return dao.find(id);
        }
    }
}
