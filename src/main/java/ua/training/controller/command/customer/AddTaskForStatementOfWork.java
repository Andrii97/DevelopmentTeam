package ua.training.controller.command.customer;

import ua.training.controller.FrontController;
import ua.training.controller.command.Command;
import ua.training.model.entity.Qualification;
import ua.training.model.entity.Task;
import ua.training.model.entity.TaskRequirements;
import ua.training.utils.constants.AttributesHolder;
import ua.training.utils.constants.PagesHolder;
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
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        addTaskToSession(request);
        response.sendRedirect(PathsHolder.BASIC + PathsHolder.ADD_STATEMENT_OF_WORK);
        return FrontController.REDIRECT;
    }

    private void addTaskToSession(HttpServletRequest request) {
        Object tasksObject = request.getSession().getAttribute(AttributesHolder.TASKS);
        List<Task> tasks;
        if(tasksObject == null) {
            tasks = new ArrayList<>();
        } else {
            tasks = (List<Task>) tasksObject;
        }
        tasks.add(getTaskFromRequest(request));

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
// todo validation numbers //d+
        taskRequirementsList.add(getTaskRequirement(Qualification.JUNIOR,
               Integer.parseInt(request.getParameter(AttributesHolder.TASK_NEEDED_JUNIORS))));
        taskRequirementsList.add(getTaskRequirement(Qualification.MIDDLE,
                Integer.parseInt(request.getParameter(AttributesHolder.TASK_NEEDED_MIDDLES))));
        taskRequirementsList.add(getTaskRequirement(Qualification.JUNIOR,
                Integer.parseInt(request.getParameter(AttributesHolder.TASK_NEEDED_SENIORS))));

        return taskRequirementsList;
    }

    private TaskRequirements getTaskRequirement(Qualification qualification, int developersNumber) {
        return new TaskRequirements.Builder()
                .setQualification(qualification)
                .setDevelopersNumber(developersNumber)
                .build();
    }
}
