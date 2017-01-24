package ua.training.controller.filter;

import org.apache.log4j.Logger;
import ua.training.controller.i18n.SupportedLocaleHolder;
import ua.training.utils.constants.AttributesHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by andrii on 23.01.17.
 */
public class LocaleFilter implements Filter {
    /**
     * Logger for logging operations.
     */
    private static final Logger logger = Logger.getLogger(LocaleFilter.class);

    public static final String PATH_TO_BUNDLE_FILE = "i18n.messages";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        setUpResourceBundleSource(req);
        changeUserLocaleByRequestParameter(req);
        setUpUserLocaleIfAbsent(req);

        chain.doFilter(request, response);
    }

    private void setUpResourceBundleSource(HttpServletRequest request) {
        if (request.getSession().getAttribute(AttributesHolder.BUNDLE_FILE) == null) {
            request.getSession().setAttribute(AttributesHolder.BUNDLE_FILE,
                    PATH_TO_BUNDLE_FILE);
        }
    }

    private void changeUserLocaleByRequestParameter(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String localeParameter = request.getParameter(AttributesHolder.USER_LOCALE);
        if (localeParameter != null) {
            Locale locale = SupportedLocaleHolder.getSupportedOrDefault(localeParameter);
            session.setAttribute(AttributesHolder.LOCALE, locale);
        }
    }

    private void setUpUserLocaleIfAbsent(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute(AttributesHolder.LOCALE) != null) {
            return;
        }
        Locale requestLocale = request.getLocale();
        Locale locale = SupportedLocaleHolder.getSupportedOrDefault(requestLocale);
        session.setAttribute(AttributesHolder.LOCALE, locale);
    }

    @Override
    public void destroy() {

    }

}
