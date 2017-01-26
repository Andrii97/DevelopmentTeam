package ua.training.controller.command.manager;

import ua.training.controller.command.Command;
import ua.training.model.entity.Role;
import ua.training.utils.constants.AttributesHolder;
import ua.training.utils.constants.PagesHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by andrii on 25.01.17.
 */
public class GetAddNewUserPage implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute(AttributesHolder.ROLES, Role.values());
        return PagesHolder.ADD_USER_PAGE;
    }
}
