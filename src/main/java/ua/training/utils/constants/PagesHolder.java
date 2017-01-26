package ua.training.utils.constants;

/**
 * Created by andrii on 21.01.17.
 */
public class PagesHolder {
    public static final String PREFIX = "/WEB-INF/view";
    public static final String LOGIN_PAGE = PREFIX + "/login.jsp";
    public static final String PROFILE = "/profile.jsp";

    public static final String ERROR_FOLDER = "/error";
    public static final String PAGE_NOT_FOUND = PREFIX + ERROR_FOLDER + "/pageNotFound.jsp";

    // customer's pages
    public static final String CUSTOMER_HOME_PAGE = PREFIX + UrlHolder.CUSTOMER_PREFIX + PROFILE;
    public static final String STATEMENTS_OF_WORK_PAGE = PREFIX + UrlHolder.CUSTOMER_PREFIX +
            "/statementsOfWork.jsp";
    public static final String STATEMENT_OF_WORK_PAGE = PREFIX + UrlHolder.CUSTOMER_PREFIX +
            "/editStatementOfWork.jsp";
    public static final String ADD_STATEMENT_OF_WORK_PAGE = PREFIX + UrlHolder.CUSTOMER_PREFIX +
            "/addStatementOfWork.jsp";





    public static final String PROJECTS = "projects.jsp";
    public static final String PROJECTS_PAGE = PREFIX + UrlHolder.MANAGER_PREFIX + PROJECTS;

    // manager's pages
    public static final String USERS = "/users.jsp";
    public static final String USERS_PAGE = PREFIX + UrlHolder.MANAGER_PREFIX + USERS;
    public static final String MANAGER_HOME_PAGE = PREFIX + UrlHolder.MANAGER_PREFIX + PROFILE;
    public static final String ADD_USER_PAGE = PREFIX + UrlHolder.MANAGER_PREFIX + "/addUser.jsp";

    // developer's pages
    public static final String DEVELOPER_HOME_PAGE = PREFIX + UrlHolder.DEVELOPER_PREFIX + PROFILE;
    public static final String TASKS_BY_DEVELOPER = PREFIX + UrlHolder.DEVELOPER_PREFIX + "/tasks.jsp";
}
