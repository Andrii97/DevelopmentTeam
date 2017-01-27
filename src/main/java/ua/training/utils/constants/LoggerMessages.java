package ua.training.utils.constants;

/**
 * Created by andrii on 24.01.17.
 */
public class LoggerMessages {
    public static final String UNAUTHORIZED_ACCESS =
            "Access denied. Requested URI='%s', userRole='%s'";
    public static final String SERVICE_ERROR_USER_EXIST =
            "Registration exception. User with this email ('%s') already exist";
    public static final String SERVICE_ERROR_USER_NOT_FOUND =
            "Login exception. User with this email ('%s') and password ('%s') not found";
}
