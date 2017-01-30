package ua.training.controller.command.developer;

import ua.training.controller.FrontController;
import ua.training.controller.command.Command;
import ua.training.controller.validator.Errors;
import ua.training.controller.validator.NumberValidator;
import ua.training.controller.validator.Validator;
import ua.training.model.entity.Developer;
import ua.training.model.entity.DeveloperHasTask;
import ua.training.model.entity.Task;
import ua.training.model.entity.User;
import ua.training.model.service.TaskService;
import ua.training.utils.constants.AttributesHolder;
import ua.training.utils.constants.PagesHolder;
import ua.training.utils.constants.PathsHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by andrii on 30.01.17.
 */
public class SetElapsedTimeForTask implements Command {
    TaskService taskService = TaskService.getInstance();
    Validator<String> numberValidator = new NumberValidator();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute(AttributesHolder.USER);
        String elapsedTime = request.getParameter(AttributesHolder.ELAPSED_TIME);
        Errors errors = new Errors();
        if(numberValidator.validate(elapsedTime, errors)) {
            DeveloperHasTask developerHasTask = getDeveloperHasTaskFromRequest(request, user);
            taskService.updateElapsedTimeForTask(developerHasTask);
            response.sendRedirect(PathsHolder.BASIC + PathsHolder.TASKS);
            return FrontController.REDIRECT;
        }
        request.setAttribute(AttributesHolder.ERRORS, errors);
        List<DeveloperHasTask> tasks = taskService.getByDeveloper(user); // todo: name
        request.setAttribute(AttributesHolder.DEVELOPER_HAS_TASKS, tasks);
        return PagesHolder.TASKS_BY_DEVELOPER;
    }

    private DeveloperHasTask getDeveloperHasTaskFromRequest(HttpServletRequest request,
                                                            User user) {
        return new DeveloperHasTask.Builder()
                .setDeveloper(new Developer.Builder()
                        .setUser(new User.Builder()
                                .setId(user.getId())
                                .build())
                        .build())
                .setElapsedTime(Integer.parseInt(request
                        .getParameter(AttributesHolder.ELAPSED_TIME)))
                .setTask(new Task.Builder()
                        .setId(Integer.parseInt(request.getParameter(AttributesHolder.TASK_ID))) // todo: parse int
                        .build())
                .build();
    }
}
