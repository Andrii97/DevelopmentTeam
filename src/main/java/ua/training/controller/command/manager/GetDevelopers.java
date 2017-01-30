package ua.training.controller.command.manager;

import ua.training.controller.command.Command;
import ua.training.model.entity.Developer;
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
public class GetDevelopers implements Command {
    DeveloperService developerService = DeveloperService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Developer> developers = developerService.getAll();
        request.setAttribute(AttributesHolder.DEVELOPERS, developers);
        return PagesHolder.DEVELOPERS_PAGE;
    }
}
