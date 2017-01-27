package ua.training.exception;

import org.apache.log4j.Logger;
import ua.training.model.service.exception.ServiceException;

/**
 * Created by andrii on 26.01.17.
 */
public class ApplicationException extends RuntimeException {
    private static Logger logger = Logger.getLogger(ApplicationException.class);
    private String messageKey;

    private String logMessage; // todo:

    protected ApplicationException() {
    }

    protected ApplicationException(String messageKey) {
        this.messageKey = messageKey;
    }

    protected ApplicationException(String messageKey, Throwable cause) {
        super(cause);
        logger.error(cause.getMessage());
        this.messageKey = messageKey;
    }

    protected ApplicationException addLogMessage(String logMessage) {
        this.logMessage = logMessage;
        return this;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public String getLogMessage() {
        return logMessage;
    }

}
