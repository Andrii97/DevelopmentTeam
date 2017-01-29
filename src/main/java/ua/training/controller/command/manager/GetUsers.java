package ua.training.controller.command.manager;

import ua.training.controller.command.Command;
import ua.training.model.entity.Developer;
import ua.training.model.entity.User;
import ua.training.model.service.DeveloperService;
import ua.training.model.service.UserService;
import ua.training.utils.constants.AttributesHolder;
import ua.training.utils.constants.PagesHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by andrii on 23.01.17.
 */
public class GetUsers implements Command {
    UserService userService = UserService.getInstance();
    DeveloperService developerService = DeveloperService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        List<User> users = userService.getAll();
//        request.getSession().setAttribute(AttributesHolder.USERS, users);
        List<Developer> developers = developerService.getAll();
        request.setAttribute(AttributesHolder.DEVELOPERS, developers);
        String pageToGo = PagesHolder.USERS_PAGE;

        return pageToGo;
    }
}
