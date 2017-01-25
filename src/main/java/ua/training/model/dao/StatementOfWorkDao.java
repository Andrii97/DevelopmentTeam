package ua.training.model.dao;

import ua.training.model.entity.StatementOfWork;
import ua.training.model.entity.User;

import java.util.List;

/**
 * Created by andrii on 16.01.17.
 */
public interface StatementOfWorkDao extends GenericDao<StatementOfWork> {
    List<StatementOfWork> findByCustomer(User customer);
}
