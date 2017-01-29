package ua.training.controller.command.customer;

import org.apache.log4j.Logger;
import ua.training.controller.FrontController;
import ua.training.controller.command.Command;
import ua.training.controller.validator.StatementOfWorkValidator;
import ua.training.controller.validator.Validator;
import ua.training.model.entity.StatementOfWork;
import ua.training.model.entity.Task;
import ua.training.model.entity.User;
import ua.training.model.service.StatementOfWorkService;
import ua.training.utils.constants.AttributesHolder;
import ua.training.utils.constants.PagesHolder;
import ua.training.utils.constants.PathsHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrii on 22.01.17.
 */
public class CreateStatementOfWork implements Command {
    private static final Logger logger = Logger.getLogger(CreateStatementOfWork.class);

    private StatementOfWorkService statementOfWorkService
            = StatementOfWorkService.getInstance();
    private Validator<StatementOfWork> statementOfWorkValidator =
            new StatementOfWorkValidator();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pageToGo = PagesHolder.ADD_STATEMENT_OF_WORK_PAGE;
        StatementOfWork statementOfWork = buildStatementOfWork(request);
        logger.error(statementOfWork.toString());
        if(statementOfWorkValidator.validate(statementOfWork)) {
            statementOfWorkService.create(statementOfWork);
            request.getSession().removeAttribute(AttributesHolder.TASKS);
            pageToGo = PathsHolder.BASIC + PathsHolder.STATEMENTS_OF_WORK_BY_CUSTOMER;
            response.sendRedirect(pageToGo);
            pageToGo = FrontController.REDIRECT;
//            pageToGo = PathsHolder.BASIC + PathsHolder.STATEMENTS_OF_WORK_BY_CUSTOMER;
        }

        return pageToGo;
    }

    private StatementOfWork buildStatementOfWork(HttpServletRequest request) {
        User customer = (User)request.getSession().getAttribute(AttributesHolder.USER);
        Object tasksObject = request.getSession().getAttribute(AttributesHolder.TASKS);
        List<Task> tasks;
        if(tasksObject == null) {
            tasks = new ArrayList<>();
        } else {
            tasks = (List<Task>) tasksObject;
        } // todo
        return new StatementOfWork.Builder()
                .setName(request.getParameter(AttributesHolder.NAME))
                .setFilingDate(LocalDate.now())
                .setCustomerId(customer.getId())
                .setTasks(tasks)
                .build();
    }
}
