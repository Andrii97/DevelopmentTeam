package ua.training.exception;

/**
 * Created by andrii on 26.01.17.
 */
public class ApplicationException extends RuntimeException {

    private String messageKey;

    private String logMessage; // todo:

    protected ApplicationException() {
    }

    protected ApplicationException(String messageKey) {
        this.messageKey = messageKey;
    }

    protected ApplicationException(String messageKey, Throwable cause) {
        super(cause);
        this.messageKey = messageKey;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public String getLogMessage() {
        return logMessage;
    }
}
