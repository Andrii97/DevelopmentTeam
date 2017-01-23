package ua.training.model.service;

import ua.training.model.dao.DaoConnection;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.ProjectDao;
import ua.training.model.entity.Project;

import java.util.List;

/**
 * Created by andrii on 23.01.17.
 */
public class ProjectService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    private static class Holder{
        static final ProjectService INSTANCE = new ProjectService();
    }

    public static ProjectService getInstance(){
        return Holder.INSTANCE;
    }

    public List<Project> getAll() {
        try( DaoConnection connection = daoFactory.getConnection() ){
            ProjectDao dao = daoFactory.createProjectDao(connection);
            return dao.findAll();
        }
    }

    public void create(Project project) {
        try( DaoConnection connection = daoFactory.getConnection() ){
            ProjectDao dao = daoFactory.createProjectDao(connection);
            dao.create(project);
        }
    }
}
