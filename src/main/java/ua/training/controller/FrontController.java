package ua.training.controller;

import ua.training.controller.command.Command;
import ua.training.controller.command.Login;
import ua.training.controller.command.Logout;
import ua.training.controller.command.customer.CreateStatementOfWork;
import ua.training.controller.command.customer.GetStatementOfWork;
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


    @Override
    public void init(){
        commands.put("GET:/login",  new Login());
        commands.put("GET:/logout",  new Logout());
        commands.put("POST:/createSOW", new CreateStatementOfWork());
        commands.put("GET:" + UrlHolder.STATEMENT_OF_WORK, new GetStatementOfWork());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = processRequest(request, response);
        response.sendRedirect(path);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = processRequest(request, response);
        request.getRequestDispatcher(path).forward(request, response);
    }

    String processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getMethod().toUpperCase();
        String path = request.getRequestURI();
        path = path.replaceAll(".*/rest", "");
        String key = method+":"+path;
        Command command = commands.getOrDefault(key, (req , resp)-> PagesHolder.LOGIN_PAGE);
        return command.execute(request, response);
    }
}
