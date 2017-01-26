package ua.training.controller.command.customer;

import ua.training.controller.FrontController;
import ua.training.controller.command.Command;
import ua.training.model.service.StatementOfWorkService;
import ua.training.utils.constants.PathsHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by andrii on 25.01.17.
 */
public class DeleteStatementOfWork implements Command {
    private StatementOfWorkService statementOfWorkService
            = StatementOfWorkService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        int statementOfWorkId = Integer.parseInt(path.replaceAll("\\D+", ""));

        statementOfWorkService.delete(statementOfWorkId);

        response.sendRedirect(PathsHolder.BASIC + PathsHolder.STATEMENTS_OF_WORK_BY_CUSTOMER);

        return FrontController.REDIRECT;
    }
}
