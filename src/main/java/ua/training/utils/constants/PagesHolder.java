package ua.training.utils.constants;

/**
 * Created by andrii on 21.01.17.
 */
public class PagesHolder {
    public static final String PREFIX = "/WEB-INF/view";
    public static final String LOGIN_PAGE = PREFIX + "/login.jsp";
    public static final String PROFILE = "/profile.jsp";

    // customer's pages
    public static final String CUSTOMER_HOME_PAGE = PREFIX + UrlHolder.CUSTOMER_PREFIX + PROFILE;
    public static final String STATEMENT_OF_WORK_PAGE = PREFIX + UrlHolder.CUSTOMER_PREFIX +
            "/statementOfWork.jsp";
    public static final String STATEMENTS_OF_WORK_PAGE = PREFIX + UrlHolder.CUSTOMER_PREFIX +
            "/statementsOfWork.jsp";
    public static final String ADD_STATEMENT_OF_WORK_PAGE = PREFIX + UrlHolder.CUSTOMER_PREFIX +
            "/addStatementsOfWork.jsp";

    // manager's pages
    public static final String MANAGER_HOME_PAGE = PREFIX + UrlHolder.MANAGER_PREFIX + PROFILE;

    // developer's pages
    public static final String DEVELOPER_HOME_PAGE = PREFIX + UrlHolder.DEVELOPER_PREFIX + PROFILE;
}
