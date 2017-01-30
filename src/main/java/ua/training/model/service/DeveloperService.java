package ua.training.model.service;

import ua.training.model.dao.DaoConnection;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.DeveloperDao;
import ua.training.model.dao.DeveloperHasTaskDao;
import ua.training.model.entity.Developer;
import ua.training.model.entity.DeveloperHasTask;
import ua.training.model.entity.Qualification;
import ua.training.model.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by andrii on 23.01.17.
 */
public class DeveloperService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    private static class Holder{
        static final DeveloperService INSTANCE = new DeveloperService();
    }

    public static DeveloperService getInstance(){
        return Holder.INSTANCE;
    }

    public List<Developer> getByQualification(Qualification qualification) {
        try( DaoConnection connection = daoFactory.getConnection() ){
            DeveloperDao dao = daoFactory.createDeveloperDao(connection);
            return dao.findByQualification(qualification);
        }
    }

    public List<Developer> getAll() {
        try( DaoConnection connection = daoFactory.getConnection() ){
            DeveloperDao dao = daoFactory.createDeveloperDao(connection);
            return dao.findAll();
        }
    }

    public List<DeveloperHasTask> getAllTasksForDeveloper() {
        try( DaoConnection connection = daoFactory.getConnection() ){
            DeveloperHasTaskDao dao = daoFactory.createDeveloperHasTaskDao(connection);
            return dao.findAll();
        }
    }

    public void createDeveloperWithQualification(Developer developer) {
        try( DaoConnection connection = daoFactory.getConnection() ){
            DeveloperDao dao = daoFactory.createDeveloperDao(connection);
            dao.create(developer);
        }
    }

    public void updateStatusFree(Developer developer) {
        try( DaoConnection connection = daoFactory.getConnection() ){
            DeveloperDao dao = daoFactory.createDeveloperDao(connection);
            connection.begin();
            Optional<Developer> oldDeveloper = dao.find(developer.getUser().getId());
            oldDeveloper.ifPresent(d -> {
                d.setFree(developer.getFree());
                dao.update(d);
            });
            dao.update(developer);
            connection.commit();
        }
    }
}
