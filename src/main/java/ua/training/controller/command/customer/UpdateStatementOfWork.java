package ua.training.controller.command.customer;

import org.apache.log4j.Logger;
import ua.training.controller.command.Command;
import ua.training.model.entity.StatementOfWork;
import ua.training.model.service.StatementOfWorkService;
import ua.training.utils.constants.AttributesHolder;
import ua.training.utils.constants.UrlHolder;

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

        return UrlHolder.BASIC + UrlHolder.STATEMENTS_OF_WORK_BY_CUSTOMER;
    }

    private StatementOfWork getStatementOfWorkFromRequest(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter(AttributesHolder.ID));
        String name = request.getParameter(AttributesHolder.NAME);
        Integer customerId = Integer.parseInt(request.getParameter(AttributesHolder.CUSTOMER_ID));
        LocalDate fillingDate = LocalDate.parse(request.getParameter(AttributesHolder.FILLING_DATE));
        Boolean isApproved = Boolean.parseBoolean(request.getParameter(AttributesHolder.APPROVED));
        return new StatementOfWork.Builder()
                .setId(id)
                .setName(name)
                .setCustomerId(customerId)
                .setFilingDate(fillingDate)
                .setApproved(isApproved)
                .build();
    }
}
