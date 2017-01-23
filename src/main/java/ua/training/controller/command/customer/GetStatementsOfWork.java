package ua.training.controller.command.customer;

import ua.training.controller.command.Command;
import ua.training.model.entity.StatementOfWork;
import ua.training.model.service.StatementOfWorkService;
import ua.training.utils.constants.AttributesHolder;
import ua.training.utils.constants.PagesHolder;
import ua.training.utils.constants.UrlHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by andrii on 23.01.17.
 */
public class GetStatementsOfWork implements Command {
    private StatementOfWorkService statementOfWorkService
            = StatementOfWorkService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<StatementOfWork> statementsOfWork =
                statementOfWorkService.getAll();

        request.setAttribute(AttributesHolder.STATEMENTS_OF_WORK, statementsOfWork);
//        response.sendRedirect(UrlHolder.BASIC + UrlHolder.STATEMENTS_OF_WORK);
        String pageToGo = PagesHolder.STATEMENTS_OF_WORK_PAGE;

        return pageToGo;
    }
}
