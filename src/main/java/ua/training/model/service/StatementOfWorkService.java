package ua.training.model.service;

import ua.training.model.dao.DaoConnection;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.StatementOfWorkDao;
import ua.training.model.entity.StatementOfWork;
import ua.training.model.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by andrii on 22.01.17.
 */
public class StatementOfWorkService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    private static class Holder{
        static final StatementOfWorkService INSTANCE = new StatementOfWorkService();
    }

    public static StatementOfWorkService getInstance(){
        return Holder.INSTANCE;
    }

    public void create(StatementOfWork statementOfWork){
        try( DaoConnection connection = daoFactory.getConnection() ){
            StatementOfWorkDao dao = daoFactory.createStatementOfWorkDao(connection);
            dao.create(statementOfWork);
            // todo add task
        }
    }

    public Optional<StatementOfWork> getById(int statementOfWorkId) {
        try( DaoConnection connection = daoFactory.getConnection() ){
            StatementOfWorkDao dao = daoFactory.createStatementOfWorkDao(connection);
            return dao.find(statementOfWorkId);
        }
    }

    public List<StatementOfWork> getByCustomer(User customer) {
        try( DaoConnection connection = daoFactory.getConnection() ){
            StatementOfWorkDao dao = daoFactory.createStatementOfWorkDao(connection);
            return dao.findByCustomer(customer);
        }
    }

    public List<StatementOfWork> getAll() {
        try( DaoConnection connection = daoFactory.getConnection() ){
            StatementOfWorkDao dao = daoFactory.createStatementOfWorkDao(connection);
            return dao.findAll();
        }
    }

    public void update(StatementOfWork statementOfWork) {
        try( DaoConnection connection = daoFactory.getConnection() ){
            StatementOfWorkDao dao = daoFactory.createStatementOfWorkDao(connection);
            dao.update(statementOfWork);
        }
    }

    public void delete(int statementOfWorkId) {
        try( DaoConnection connection = daoFactory.getConnection() ){
            StatementOfWorkDao dao = daoFactory.createStatementOfWorkDao(connection);
            dao.delete(statementOfWorkId);
        }
    }
}
