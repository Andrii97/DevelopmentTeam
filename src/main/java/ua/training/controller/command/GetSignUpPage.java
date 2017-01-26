package ua.training.controller.command;

import ua.training.controller.FrontController;
import ua.training.model.entity.Role;
import ua.training.utils.constants.AttributesHolder;
import ua.training.utils.constants.PagesHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by andrii on 26.01.17.
 */
public class GetSignUpPage implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute(AttributesHolder.ERRORS) != null) {
            request.setAttribute(AttributesHolder.ERRORS, request.getSession().getAttribute(AttributesHolder.ERRORS));
            request.getSession().setAttribute(AttributesHolder.ERRORS, null);
            request.setAttribute(AttributesHolder.USER, request.getSession().getAttribute(AttributesHolder.USER));
            request.getSession().setAttribute(AttributesHolder.USER, null);
        }
        request.setAttribute(AttributesHolder.ROLES, Role.values());
        return PagesHolder.SIGN_UP;
    }
}
