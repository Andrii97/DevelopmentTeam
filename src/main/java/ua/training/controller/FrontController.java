package ua.training.controller;

import org.apache.log4j.Logger;
import ua.training.controller.command.Command;
import ua.training.controller.validator.RegExp;
import ua.training.exception.ApplicationException;
import ua.training.utils.constants.AttributesHolder;
import ua.training.utils.constants.PagesHolder;
import ua.training.utils.constants.PathsHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by andrii on 21.01.17.
 */
public class FrontController extends HttpServlet {
//    private static final long serialVersionUID = 1L;

    public static final String REDIRECT = "redirect";

    private static final Logger logger = Logger.getLogger(FrontController.class);

    CommandHolder commandHolder;

    @Override
    public void init(){
        commandHolder = new CommandHolder();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String commandKey = getMethod(request) + CommandHolder.DELIMITER + getPath(request);
        logger.debug("KEY = " + commandKey);
        Command command = commandHolder.getCommand(commandKey);
        logger.debug(command);
        checkIfErrorIsPresent(request);
        executeCommand(request, response, command);
    }

    private void executeCommand(HttpServletRequest request, HttpServletResponse response, Command command) throws IOException {
        try{
            String path = command.execute(request, response);
            if(!isRedirected(path)) {
                request.getRequestDispatcher(path).forward(request, response);
            } else {
                request.removeAttribute(AttributesHolder.ERROR_MESSAGE);
            }
            return;
        } catch (ApplicationException e) {
            request.getSession().setAttribute(AttributesHolder.ERROR_MESSAGE, e.getMessageKey());
        } catch (Exception e) {
            request.getSession().setAttribute(AttributesHolder.ERROR_MESSAGE, "I don't know");
        }
        response.sendRedirect(request.getRequestURI());
        logger.error(AttributesHolder.ERROR_MESSAGE);
    }

    private void checkIfErrorIsPresent(HttpServletRequest request) {
        request.setAttribute(AttributesHolder.ERROR_MESSAGE,
                request.getSession().getAttribute(AttributesHolder.ERROR_MESSAGE));
        request.getSession().removeAttribute(AttributesHolder.ERROR_MESSAGE);
    }

    private boolean isRedirected(String path) {
        return REDIRECT.equals(path);
    }

    private String getPath(HttpServletRequest request) {
        String path = request.getRequestURI();
        logger.debug("URI " + path);
        return path
                .replaceAll(PathsHolder.BASIC, "")
                .replaceAll(RegExp.NUMBER, "");
    }

    private String getMethod(HttpServletRequest request) {
        return request.getMethod().toUpperCase();
    }
}
