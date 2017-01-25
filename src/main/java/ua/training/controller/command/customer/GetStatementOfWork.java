package ua.training.controller.command.customer;

import ua.training.controller.command.Command;
import ua.training.model.entity.StatementOfWork;
import ua.training.model.service.StatementOfWorkService;
import ua.training.utils.constants.AttributesHolder;
import ua.training.utils.constants.PagesHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * Created by andrii on 23.01.17.
 */
public class GetStatementOfWork implements Command {
    private StatementOfWorkService statementOfWorkService
            = StatementOfWorkService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getRequestURI();
        int statementOfWorkId = Integer.parseInt(path.replaceAll("\\D+", ""));

        Optional<StatementOfWork> statementOfWork = statementOfWorkService
                .getById(statementOfWorkId);
        statementOfWork.ifPresent((sow) -> request.setAttribute(AttributesHolder.STATEMENT_OF_WORK, sow));

        return PagesHolder.STATEMENT_OF_WORK_PAGE;
    }
}
