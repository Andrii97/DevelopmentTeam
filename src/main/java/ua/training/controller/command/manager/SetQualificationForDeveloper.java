package ua.training.controller.command.manager;

import org.apache.log4j.Logger;
import ua.training.controller.FrontController;
import ua.training.controller.command.Command;
import ua.training.controller.validator.DeveloperValidator;
import ua.training.controller.validator.Errors;
import ua.training.controller.validator.Validator;
import ua.training.model.entity.Developer;
import ua.training.model.entity.Qualification;
import ua.training.model.entity.User;
import ua.training.model.service.DeveloperService;
import ua.training.utils.constants.AttributesHolder;
import ua.training.utils.constants.PagesHolder;
import ua.training.utils.constants.PathsHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by andrii on 23.01.17.
 */
public class SetQualificationForDeveloper implements Command {
    private static Logger logger = Logger.getLogger(SetQualificationForDeveloper.class);
    DeveloperService developerService = DeveloperService.getInstance();
    Validator<Developer> developerValidator = new DeveloperValidator();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Developer developer = getDeveloperFromRequest(request);
        Errors errors = new Errors();
        if(developerValidator.validate(developer, errors)) {
            developerService.createDeveloperWithQualification(developer);
            response.sendRedirect(PathsHolder.BASIC + PathsHolder.DEVELOPERS);
            return FrontController.REDIRECT;
        }
        request.setAttribute(AttributesHolder.ERRORS, errors);
        List<Developer> developers = developerService.getAll();
        request.setAttribute(AttributesHolder.DEVELOPERS, developers);
        return PagesHolder.DEVELOPERS_PAGE;
    }

    private Developer getDeveloperFromRequest(HttpServletRequest request) {
        String qualification = request.getParameter(AttributesHolder.QUALIFICATION);
        return new Developer.Builder()
                .setUser(new User.Builder()
                        .setId(Integer.parseInt(request.getParameter(AttributesHolder.ID)))
                        .build())
                .setQualification(getQualificationFromString(qualification))
                .build();
    }

    private Qualification getQualificationFromString(String qualification) {
        return qualification == null || qualification.equals("") ?
                null : Qualification.valueOf(qualification);
    }
}
