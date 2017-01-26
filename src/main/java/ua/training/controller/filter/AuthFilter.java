package ua.training.controller.filter;

import org.apache.log4j.Logger;
import ua.training.model.entity.Role;
import ua.training.model.entity.User;
import ua.training.utils.constants.AttributesHolder;
import ua.training.utils.constants.LoggerMessages;
import ua.training.utils.constants.PathsHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by andrii on 24.01.17.
 */
public class AuthFilter implements Filter {

    private static Logger logger = Logger.getLogger(AuthFilter.class);

    private Map<Role, String> roleUrlMap;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        roleUrlMap = new HashMap<>();
        roleUrlMap.put(Role.MANAGER, PathsHolder.MANAGER_URL);
        roleUrlMap.put(Role.CUSTOMER, PathsHolder.CUSTOMER_URL);
        roleUrlMap.put(Role.DEVELOPER, PathsHolder.DEVELOPER_URL);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        Role role = getUserRole(req);
        if (!checkUriByRole(uri, role)) {
            resp.sendRedirect(getHomeUrl(role));
            logger.info(String.format(LoggerMessages.UNAUTHORIZED_ACCESS, uri, role));
            return;
        }
        chain.doFilter(request, response);
    }

    private String getHomeUrl(Role role) {
        return role == null ? PathsHolder.LOGIN : roleUrlMap.get(role);
    }

    private Role getUserRole(HttpServletRequest request) {
        Role role = null;
        HttpSession session = request.getSession();
        Object userObject = session.getAttribute(AttributesHolder.USER);
        if (userObject != null) {
            User user = (User) userObject;
            role = user.getRole();
        }
        return role;
    }

    private boolean checkUriByRole(String uri, Role role) {
        return role != null && uri.startsWith(roleUrlMap.get(role));
    }

    @Override
    public void destroy() {

    }
}
