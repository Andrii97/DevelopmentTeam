package ua.training.controller.command.developer;

import ua.training.controller.command.Command;
import ua.training.model.entity.Task;
import ua.training.model.entity.User;
import ua.training.model.service.DeveloperService;
import ua.training.model.service.TaskService;
import ua.training.utils.constants.AttributesHolder;
import ua.training.utils.constants.PagesHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by andrii on 25.01.17.
 */
public class GetTasksByDeveloper implements Command {
    TaskService taskService = TaskService.getInstance();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User developer = (User) request.getSession().getAttribute(AttributesHolder.USER);

        List<Task> tasks = taskService.getByDeveloper(developer);
        request.setAttribute(AttributesHolder.TASKS, tasks);

        return PagesHolder.TASKS_BY_DEVELOPER;
    }
}
