package ua.training.controller.command;

import ua.training.controller.FrontController;
import ua.training.model.entity.*;
import ua.training.model.service.UserService;
import ua.training.utils.constants.AttributesHolder;
import ua.training.utils.constants.PagesHolder;
import ua.training.utils.constants.PathsHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by andrii on 21.01.17.
 */
public class Login implements Command {
    private UserService userService = UserService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pageToGo = PagesHolder.LOGIN_PAGE;
        String email = request.getParameter(AttributesHolder.EMAIL);
        String password = request.getParameter(AttributesHolder.PASSWORD);
        if( email != null && password != null ){
            User user = userService.login(email, password);
            request.getSession()
                    .setAttribute(AttributesHolder.USER, user);
            pageToGo = PathsHolder.roleUrlMap.get(user.getRole());
            response.sendRedirect(pageToGo);
            pageToGo = FrontController.REDIRECT;
        }
        return pageToGo;
    }
}
