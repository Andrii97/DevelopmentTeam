package ua.training.controller.command.manager;

import ua.training.controller.command.Command;
import ua.training.model.entity.Project;
import ua.training.model.service.ProjectService;
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
public class GetProjects implements Command {
    private ProjectService projectService = ProjectService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Project> projects = projectService.getAll();
        request.setAttribute(AttributesHolder.PROJECTS, projects);

        String pageToGo = PagesHolder.PROJECTS_PAGE;

        return pageToGo;
    }
}
