package ua.training.controller.command.manager;

import ua.training.controller.command.Command;
import ua.training.model.entity.Project;
import ua.training.model.entity.StatementOfWork;
import ua.training.model.service.ProjectService;
import ua.training.model.service.StatementOfWorkService;
import ua.training.utils.constants.AttributesHolder;
import ua.training.utils.constants.PagesHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * Created by andrii on 29.01.17.
 */
public class CreateProject implements Command {
    private ProjectService projectService = ProjectService.getInstance();
    private StatementOfWorkService statementOfWorkService
            = StatementOfWorkService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        int statementOfWorkId = Integer.parseInt(path.replaceAll("\\D+", ""));

        Optional<StatementOfWork> statementOfWork = statementOfWorkService.getById(statementOfWorkId);
        statementOfWork.ifPresent((sow) -> request.setAttribute(AttributesHolder.STATEMENT_OF_WORK, sow));
        // todo if not present
        return PagesHolder.CREATE_PROJECT_PAGE;
    }
}
