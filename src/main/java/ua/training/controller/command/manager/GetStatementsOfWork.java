package ua.training.controller.command.manager;

import ua.training.controller.command.Command;
import ua.training.model.entity.StatementOfWork;
import ua.training.model.service.StatementOfWorkService;
import ua.training.utils.constants.AttributesHolder;
import ua.training.utils.constants.PagesHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by andrii on 29.01.17.
 */
public class GetStatementsOfWork implements Command {
    private StatementOfWorkService statementOfWorkService
            = StatementOfWorkService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<StatementOfWork> statementsOfWork =
                statementOfWorkService.getAll();

        request.setAttribute(AttributesHolder.STATEMENTS_OF_WORK, statementsOfWork);
//        response.sendRedirect(PathsHolder.BASIC + PathsHolder.STATEMENTS_OF_WORK_BY_CUSTOMER);
        String pageToGo = PagesHolder.MANAGER_STATEMENTS_OF_WORK_PAGE;

        return pageToGo;
    }
}
