package ua.training.model.service;

import ua.training.model.dao.DaoConnection;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.StatementOfWorkDao;
import ua.training.model.entity.StatementOfWork;

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
}
