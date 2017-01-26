package ua.training.controller;

import org.apache.log4j.Logger;
import ua.training.controller.command.Command;
import ua.training.controller.command.GetLoginPage;
import ua.training.controller.command.Login;
import ua.training.controller.command.Logout;
import ua.training.controller.command.customer.*;
import ua.training.controller.command.developer.GetDeveloperHomePage;
import ua.training.controller.command.developer.GetTasksByDeveloper;
import ua.training.controller.command.manager.AddNewUser;
import ua.training.controller.command.manager.GetAddNewUserPage;
import ua.training.controller.command.manager.GetManagerHomePage;
import ua.training.controller.command.manager.GetUsers;
import ua.training.utils.constants.PagesHolder;
import ua.training.utils.constants.UrlHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by andrii on 21.01.17.
 */
public class FrontController extends HttpServlet {
//    private static final long serialVersionUID = 1L;

    public static final String REDIRECT = "redirect";

    private static final String GET = "GET";
    private static final String POST = "POST";

    private Map<String , Command> commands = new HashMap<>();

    private static final Logger logger = Logger.getLogger(FrontController.class);

    @Override
    public void init(){
        commands.put(GET + ":/login", new GetLoginPage());
        commands.put(POST + ":/login",  new Login());

        commands.put(GET + ":" + UrlHolder.CUSTOMER_PREFIX, new GetCustomerHomePage());
        commands.put(GET + ":" + UrlHolder.MANAGER_PREFIX, new GetManagerHomePage());
        commands.put(GET + ":" + UrlHolder.DEVELOPER_PREFIX, new GetDeveloperHomePage());

        commands.put(GET + ":" + UrlHolder.LOGOUT_PREFIX,  new Logout());

        // customer's
        commands.put(GET + ":" + UrlHolder.ADD_STATEMENT_OF_WORK,
                (req , resp)-> PagesHolder.ADD_STATEMENT_OF_WORK_PAGE);
        commands.put(POST + ":" + UrlHolder.ADD_STATEMENT_OF_WORK, new CreateStatementOfWork());
        commands.put(GET + ":" + UrlHolder.STATEMENT_OF_WORK, new GetStatementOfWork());
        commands.put(GET + ":" + UrlHolder.STATEMENTS_OF_WORK_BY_CUSTOMER,
                new GetStatementsOfWorkByCustomer());
        commands.put(POST + ":" + UrlHolder.STATEMENT_OF_WORK, new UpdateStatementOfWork());
        commands.put(GET + ":" + UrlHolder.DELETE_STATEMENT_OF_WORK, new DeleteStatementOfWork());

        // manager's
        commands.put(GET + ":" + UrlHolder.USERS, new GetUsers());
        commands.put(GET + ":" + UrlHolder.ADD_USER, new GetAddNewUserPage());
        commands.put(POST + ":" + UrlHolder.ADD_USER, new AddNewUser());
        commands.put(GET + ":" + UrlHolder.TASKS, new GetTasksByDeveloper());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = processRequest(request, response);
        logger.info("GOTO redirect" + path);
        response.sendRedirect(path);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = processRequest(request, response);
        if(!path.equals(REDIRECT)) {
            logger.info("GOTO forward " + path);
            request.getRequestDispatcher(path).forward(request, response);
        }
    }

    String processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getMethod().toUpperCase();
        String path = request.getRequestURI();
        logger.debug("URL " + path);
        path = path.replaceAll(UrlHolder.BASIC, "").replaceAll("\\d+", ""); // ".*/rest"
        String key = method + ":" + path;
        logger.debug("KEY = " + key);
        Command command = commands.getOrDefault(key, (req , resp)-> PagesHolder.PAGE_NOT_FOUND);
        logger.debug(command);
        return command.execute(request, response);
    }
}
