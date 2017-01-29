package ua.training.controller.command.customer;

import org.apache.log4j.Logger;
import ua.training.controller.FrontController;
import ua.training.controller.command.Command;
import ua.training.model.entity.StatementOfWork;
import ua.training.model.entity.User;
import ua.training.model.service.StatementOfWorkService;
import ua.training.utils.constants.AttributesHolder;
import ua.training.utils.constants.PathsHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Created by andrii on 25.01.17.
 */
public class UpdateStatementOfWork implements Command {
    private static Logger logger = Logger.getLogger(UpdateStatementOfWork.class);
    private StatementOfWorkService statementOfWorkService
            = StatementOfWorkService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StatementOfWork statementOfWork = getStatementOfWorkFromRequest(request);
        logger.debug(statementOfWork.toString());
        statementOfWorkService.update(statementOfWork);
        response.sendRedirect(PathsHolder.BASIC + PathsHolder.STATEMENTS_OF_WORK_BY_CUSTOMER);
        return FrontController.REDIRECT;
    }

    private StatementOfWork getStatementOfWorkFromRequest(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter(AttributesHolder.ID));
        String name = request.getParameter(AttributesHolder.NAME);
        User customer = (User)request.getSession().getAttribute(AttributesHolder.USER);
        LocalDate fillingDate = LocalDate.parse(request.getParameter(AttributesHolder.FILLING_DATE));
        Boolean isApproved = Boolean.parseBoolean(request.getParameter(AttributesHolder.APPROVED));
        return new StatementOfWork.Builder()
                .setId(id)
                .setName(name)
                .setCustomer(customer)
                .setFilingDate(fillingDate)
                .setApproved(isApproved)
                .build();
    }
}
