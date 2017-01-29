package ua.training.controller.command.customer;

import ua.training.controller.FrontController;
import ua.training.controller.command.Command;
import ua.training.controller.validator.Errors;
import ua.training.controller.validator.NumberValidator;
import ua.training.controller.validator.TaskValidator;
import ua.training.controller.validator.Validator;
import ua.training.model.entity.Qualification;
import ua.training.model.entity.Task;
import ua.training.model.entity.TaskRequirements;
import ua.training.utils.constants.AttributesHolder;
import ua.training.utils.constants.PathsHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrii on 27.01.17.
 */
public class AddTaskForStatementOfWork implements Command {
    private Validator<String> numberValidator = new NumberValidator();
    private Validator<Task> taskValidator = new TaskValidator();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        addTaskToSession(request);
        response.sendRedirect(PathsHolder.BASIC + PathsHolder.ADD_STATEMENT_OF_WORK);
        return FrontController.REDIRECT; // PagesHolder.ADD_STATEMENT_OF_WORK_PAGE;
//         todo post redirect get transfer errors
    }

    private void addTaskToSession(HttpServletRequest request) {
        Object tasksObject = request.getSession().getAttribute(AttributesHolder.TASKS);
        List<Task> tasks;
        if(tasksObject == null) {
            tasks = new ArrayList<>();
        } else {
            tasks = (List<Task>) tasksObject;
        }
        Task task = getTaskFromRequest(request);
        if(taskValidator.validate(task)) {
            tasks.add(task);
        }
        System.out.println(tasks);
        request.getSession().setAttribute(AttributesHolder.TASKS, tasks);
    }

    private Task getTaskFromRequest(HttpServletRequest request) {
        return new Task.Builder()
                .setName(request.getParameter(AttributesHolder.TASK_NAME))
                .setDescription(request.getParameter(AttributesHolder.TASK_DESCRIPTION))
                .setTaskRequirements(getTaskRequirementsFromRequest(request))
                .build();
    }

    private List<TaskRequirements> getTaskRequirementsFromRequest(HttpServletRequest request) {
        List<TaskRequirements> taskRequirementsList = new ArrayList<>();
        String neededJuniors = request.getParameter(AttributesHolder.TASK_NEEDED_JUNIORS);
        String neededMiddles = request.getParameter(AttributesHolder.TASK_NEEDED_MIDDLES);
        String neededSeniors = request.getParameter(AttributesHolder.TASK_NEEDED_SENIORS);
        Errors errors = new Errors(); // todo great way for validation numbers //d+
        if(!numberValidator.validate(neededJuniors, errors) ||
                !numberValidator.validate(neededMiddles, errors) ||
                !numberValidator.validate(neededSeniors, errors)) {
            request.setAttribute(AttributesHolder.ERRORS, errors);
            return null;
        }
        taskRequirementsList.add(getTaskRequirement(Qualification.JUNIOR,
                Integer.parseInt(neededJuniors)));
        taskRequirementsList.add(getTaskRequirement(Qualification.MIDDLE,
                Integer.parseInt(neededMiddles)));
        taskRequirementsList.add(getTaskRequirement(Qualification.SENIOR,
                Integer.parseInt(neededSeniors)));

        return taskRequirementsList;
    }

    private TaskRequirements getTaskRequirement(Qualification qualification, int developersNumber) {
        return new TaskRequirements.Builder()
                .setQualification(qualification)
                .setDevelopersNumber(developersNumber)
                .build();
    }

}
