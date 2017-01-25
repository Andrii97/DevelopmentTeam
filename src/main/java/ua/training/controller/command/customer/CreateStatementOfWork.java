package ua.training.controller.command.customer;

import org.apache.log4j.Logger;
import ua.training.controller.command.Command;
import ua.training.model.entity.StatementOfWork;
import ua.training.model.entity.User;
import ua.training.model.service.StatementOfWorkService;
import ua.training.utils.constants.AttributesHolder;
import ua.training.utils.constants.PagesHolder;
import ua.training.utils.constants.UrlHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Created by andrii on 22.01.17.
 */
public class CreateStatementOfWork implements Command {
    private static final Logger logger = Logger.getLogger(CreateStatementOfWork.class);

    private StatementOfWorkService statementOfWorkService
            = StatementOfWorkService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pageToGo = PagesHolder.ADD_STATEMENT_OF_WORK_PAGE;
        String name = request.getParameter(AttributesHolder.NAME);
        logger.error(request.getCharacterEncoding());
        logger.error(name);
        if(name != null){
            StatementOfWork statementOfWork = buildStatementOfWork(request, name);
            logger.error(statementOfWork.toString());
            statementOfWorkService.create(statementOfWork);
            request.getSession().setAttribute(AttributesHolder.STATEMENT_OF_WORK, statementOfWork);
            pageToGo = UrlHolder.BASIC + UrlHolder.STATEMENTS_OF_WORK_BY_CUSTOMER;
        }

        return pageToGo;
    }

    private StatementOfWork buildStatementOfWork(HttpServletRequest request, String name) {
        User customer = (User)request.getSession().getAttribute(AttributesHolder.USER);
        return new StatementOfWork.Builder()
                .setName(name)
                .setFilingDate(LocalDate.now())
                .setCustomerId(customer.getId())
                .build();
    }
}
