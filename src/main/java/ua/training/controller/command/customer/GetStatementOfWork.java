package ua.training.controller.command.customer;

import ua.training.controller.command.Command;
import ua.training.model.entity.StatementOfWork;
import ua.training.utils.constants.AttributesHolder;
import ua.training.utils.constants.PagesHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.training.controller.command.customer.CreateStatementOfWork.PARAM_NAME;

/**
 * Created by andrii on 23.01.17.
 */
public class GetStatementOfWork implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pageToGo = PagesHolder.CUSTOMER_HOME_PAGE;

        String name = request.getParameter(PARAM_NAME);

        StatementOfWork statementOfWork = (StatementOfWork) request
                .getAttribute(AttributesHolder.STATEMENT_OF_WORK);
        if(statementOfWork == null) {
            System.out.println("ERROR");
            statementOfWork = (StatementOfWork) request
                    .getSession()
                    .getAttribute(AttributesHolder.STATEMENT_OF_WORK);
        }

        if(statementOfWork == null) {
            System.out.println("ERROR 2");
        }

        if(statementOfWork != null){
            pageToGo = PagesHolder.STATEMENT_OF_WORK_PAGE;
        }

        return pageToGo;
    }
}
