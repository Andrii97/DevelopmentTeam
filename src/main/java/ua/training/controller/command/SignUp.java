package ua.training.controller.command;

import ua.training.controller.FrontController;
import ua.training.controller.security.Md5Encryption;
import ua.training.controller.validator.Errors;
import ua.training.controller.validator.UserValidator;
import ua.training.controller.validator.Validator;
import ua.training.model.entity.Role;
import ua.training.model.entity.User;
import ua.training.model.service.UserService;
import ua.training.utils.constants.AttributesHolder;
import ua.training.utils.constants.PathsHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by andrii on 26.01.17.
 */
public class SignUp implements Command {
    private UserService userService = UserService.getInstance();
    private Validator<User> userValidator = new UserValidator();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = buildUser(request);
        Errors errors = new Errors();
        System.out.println(user);
        if (userValidator.validate(user, errors)) {
            // generate hash password
            user.setPassword(Md5Encryption.encrypt(user.getPassword()));

            userService.create(user);

            // update session
            HttpSession session = request.getSession();
            session.setAttribute(AttributesHolder.USER, user);

            // redirect to profile
            response.sendRedirect(Login.afterLoginPathToGoByRole.get(user.getRole()));
            return FrontController.REDIRECT;
//            // todo: user exist
//            errors.addMessage(AttributesHolder.EMAIL, ErrorsMessages.USER_EXIST);
//            errors.setResult(false);
        }
        user.setPassword(null);
        request.getSession().setAttribute(AttributesHolder.USER, user);
        request.getSession().setAttribute(AttributesHolder.ERRORS, errors);
        return PathsHolder.BASIC + PathsHolder.SIGN_UP;
    }

    private User buildUser(HttpServletRequest request) {
        String role = request.getParameter(AttributesHolder.ROLE);
        return new User.Builder()
                .setFirstName(request.getParameter(AttributesHolder.FIRST_NAME))
                .setMiddleName(request.getParameter(AttributesHolder.MIDDLE_NAME))
                .setLastName(request.getParameter(AttributesHolder.LAST_NAME))
                .setEmail(request.getParameter(AttributesHolder.EMAIL))
                .setPassword(request.getParameter(AttributesHolder.PASSWORD))
                .setRole(role.equals("") ? null : Role.valueOf(role)) // ? todo: illegalArgumentException
                .build();
    }
}
