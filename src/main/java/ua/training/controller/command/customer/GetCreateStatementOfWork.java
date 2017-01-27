package ua.training.controller.command.customer;

import ua.training.controller.command.Command;
import ua.training.model.entity.Task;
import ua.training.utils.constants.AttributesHolder;
import ua.training.utils.constants.PagesHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by andrii on 27.01.17.
 */
public class GetCreateStatementOfWork implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        addTasksToRequest(request);
        return PagesHolder.ADD_STATEMENT_OF_WORK_PAGE;
    }

    private void addTasksToRequest(HttpServletRequest request) {
        Object tasks = request.getSession().getAttribute(AttributesHolder.TASKS);
        if (tasks != null) {
            request.setAttribute(AttributesHolder.TASKS, tasks);
            System.out.println("I am here");
            System.out.println(tasks);
        } else {
            System.out.println("Tasks is null");
        }
    }
}
