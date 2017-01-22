package ua.training.utils.constants;

/**
 * Created by andrii on 21.01.17.
 */
public class PagesHolder {
    public static final String PREFIX = "/WEB-INF/view/";
    public static final String LOGIN = PREFIX + "/login.jsp";
    public static final String PROFILE = "/profile.jsp";
    public static final String CUSTOMER_HOME_PAGE = PREFIX + UrlHolder.CUSTOMER_PREFIX + PROFILE;
    public static final String MANAGER_HOME_PAGE = PREFIX + UrlHolder.MANAGER_PREFIX + PROFILE;
    public static final String DEVELOPER_HOME_PAGE = PREFIX + UrlHolder.DEVELOPER_PREFIX + PROFILE;
}
