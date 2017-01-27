package ua.training.utils.constants;

/**
 * Created by andrii on 21.01.17.
 */
public class PathsHolder {
    public static final String BASIC = "/rest";

    public static final String LOGIN_PREFIX = "/login";
    public static final String LOGIN = BASIC + LOGIN_PREFIX;
    public static final String LOGOUT_PREFIX = "/logout";
    public static final String LOGOUT = BASIC + LOGOUT_PREFIX;
    public static final String SIGN_UP = "/signup";

    public static final String DEVELOPER_PREFIX = "/developer";
    public static final String MANAGER_PREFIX = "/manager";
    public static final String CUSTOMER_PREFIX = "/customer";
    public static final String DEVELOPER_URL = BASIC + "/developer";
    public static final String MANAGER_URL = BASIC + "/manager";
    public static final String CUSTOMER_URL = BASIC + "/customer";

    public static final String STATEMENTS_OF_WORK_BY_CUSTOMER = CUSTOMER_PREFIX + "/statementsOfWork";
    public static final String STATEMENT_OF_WORK = STATEMENTS_OF_WORK_BY_CUSTOMER + "/statementOfWork/";
    public static final String DELETE_STATEMENT_OF_WORK = STATEMENTS_OF_WORK_BY_CUSTOMER + "/delete/";
    public static final String ADD_STATEMENT_OF_WORK = STATEMENTS_OF_WORK_BY_CUSTOMER + "/createSOW";
    public static final String ADD_TASK = ADD_STATEMENT_OF_WORK + "/addTask";

    public static final String USERS = MANAGER_PREFIX + "/users";
    public static final String ADD_USER = USERS + "/addUser";

    public static final String TASKS = DEVELOPER_PREFIX + "/tasks";
    public static final String PROJECTS = MANAGER_PREFIX + "/projects";

    public static final String PAGE_NOT_FOUND = "/notFound";
}
