package ua.training.controller.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by andrii on 25.01.17.
 */
public class EncodingFilter implements Filter {
    private static final String ENCODING = "utf-8";
    private static final Logger logger = Logger.getLogger(EncodingFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        setCharacterEncoding(request, response);
        chain.doFilter(request, response);
    }

    private void setCharacterEncoding(ServletRequest request, ServletResponse response) {
        try {
            request.setCharacterEncoding(ENCODING);
            response.setCharacterEncoding(ENCODING);
        } catch (UnsupportedEncodingException e) {
            logger.error(e);
        }
    }

    @Override
    public void destroy() {

    }
}
