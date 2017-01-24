package ua.training.controller;

import org.apache.log4j.Logger;
import ua.training.controller.command.Command;
import ua.training.controller.command.Login;
import ua.training.controller.command.Logout;
import ua.training.controller.command.customer.CreateStatementOfWork;
import ua.training.controller.command.customer.GetCustomerHomePage;
import ua.training.controller.command.customer.GetStatementOfWork;
import ua.training.controller.command.customer.GetStatementsOfWork;
import ua.training.controller.command.developer.GetDeveloperHomePage;
import ua.training.controller.command.manager.GetManagerHomePage;
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

    private Map<String , Command> commands = new HashMap<>();

    private static final Logger logger = Logger.getLogger(FrontController.class);

    @Override
    public void init(){
        commands.put("POST:/login",  new Login());

        commands.put("GET:" + UrlHolder.CUSTOMER_PREFIX, new GetCustomerHomePage());
        commands.put("GET:" + UrlHolder.MANAGER_PREFIX, new GetManagerHomePage());
        commands.put("GET:" + UrlHolder.DEVELOPER_PREFIX, new GetDeveloperHomePage());

        commands.put("POST:" + UrlHolder.LOGOUT_PREFIX,  new Logout());

        commands.put("GET:" + UrlHolder.M_STATEMENTS_OF_WORK, new GetStatementsOfWork());

        commands.put("POST:/createSOW", new CreateStatementOfWork());
        commands.put("GET:" + UrlHolder.STATEMENT_OF_WORK, new GetStatementOfWork());
        commands.put("GET:" + UrlHolder.STATEMENTS_OF_WORK, new GetStatementsOfWork());

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
        logger.info("GOTO forward " + path);
        request.getRequestDispatcher(path).forward(request, response);
    }

    String processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getMethod().toUpperCase();
        String path = request.getRequestURI();
        path = path.replaceAll(UrlHolder.BASIC, ""); // ".*/rest"
        String key = method+":"+path;
        Command command = commands.getOrDefault(key, (req , resp)-> PagesHolder.LOGIN_PAGE);
        return command.execute(request, response);
    }
}
