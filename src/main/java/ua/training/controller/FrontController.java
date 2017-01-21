package ua.training.controller;

import ua.training.controller.command.Command;
import ua.training.controller.command.Login;
import ua.training.controller.command.Logout;
import ua.training.utils.constants.PagesHolder;

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
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod().toUpperCase();
        String path = request.getRequestURI();
        path = path.replaceAll(".*/rest", "");
        String key = method+":"+path;
        Command command = commands.getOrDefault(key, (req , resp)-> PagesHolder.LOGIN);
        String viewPage = command.execute(request, response);
        request.getRequestDispatcher(viewPage)
                .forward(request, response);
    }
}
