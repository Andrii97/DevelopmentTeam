package ua.training.model.service;

import ua.training.model.dao.DaoConnection;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.DeveloperDao;
import ua.training.model.entity.Developer;
import ua.training.model.entity.Qualification;
import ua.training.model.entity.User;

import java.util.List;

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
}
