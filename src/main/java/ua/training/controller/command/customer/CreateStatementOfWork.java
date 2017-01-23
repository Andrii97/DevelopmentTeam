package ua.training.controller.command.customer;

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

    public static final String PARAM_NAME = "name";

    private StatementOfWorkService statementOfWorkService
            = StatementOfWorkService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pageToGo = PagesHolder.CUSTOMER_HOME_PAGE;
        String name = request.getParameter(PARAM_NAME);

        if(name != null){
            User customer = (User)request.getSession().getAttribute(AttributesHolder.USER);
            StatementOfWork statementOfWork = new StatementOfWork.Builder()
                    .setName(name)
                    .setFilingDate(LocalDate.now())
                    .setCustomerId(customer.getId())
                    .build();
            statementOfWorkService.create(statementOfWork);
            request.setAttribute(AttributesHolder.STATEMENT_OF_WORK, statementOfWork);
            request.getSession().setAttribute(AttributesHolder.STATEMENT_OF_WORK, statementOfWork);
            pageToGo = "/rest" + UrlHolder.STATEMENT_OF_WORK;
        }

        return pageToGo;
    }
}
