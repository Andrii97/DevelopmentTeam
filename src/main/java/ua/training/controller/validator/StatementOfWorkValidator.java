package ua.training.controller.validator;

import ua.training.model.entity.StatementOfWork;

/**
 * Created by andrii on 29.01.17.
 */
public class StatementOfWorkValidator implements Validator<StatementOfWork> {
    @Override
    public boolean validate(StatementOfWork statementOfWork, Errors errors) {
        return false;
    }

    @Override
    public boolean validate(StatementOfWork statementOfWork) {
        return !(statementOfWork.getName() == null ||
                statementOfWork.getName().equals("") || // todo pattern for name
                statementOfWork.getTasks().isEmpty() ||
                statementOfWork.getFilingDate() == null);
    }
}
