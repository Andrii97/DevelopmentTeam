package ua.training.model.service.exception;

import ua.training.controller.i18n.ErrorsMessages;
import ua.training.exception.ApplicationException;

/**
 * Created by andrii on 27.01.17.
 */
public class ServiceException extends ApplicationException {
    public ServiceException(){
        super(ErrorsMessages.SERVICE_ERROR);
    }

    public ServiceException(Exception cause) {
        super(ErrorsMessages.SERVICE_ERROR, cause);
    }

    public ServiceException(String messageKey) {
        super(messageKey);
    }

    @Override
    public ServiceException addLogMessage(String logMessage) {
        super.addLogMessage(logMessage);
        return this;
    }
}
