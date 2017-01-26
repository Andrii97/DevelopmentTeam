package ua.training.model.dao.exception;

import ua.training.controller.i18n.ErrorsMessages;
import ua.training.exception.ApplicationExeption;

/**
 * Created by andrii on 26.01.17.
 */
public class DaoException extends ApplicationExeption {

    public DaoException(){
        super(ErrorsMessages.DAO_ERROR);
    }

    public DaoException(Exception cause) {
        super(ErrorsMessages.DAO_ERROR, cause);
    }
}
