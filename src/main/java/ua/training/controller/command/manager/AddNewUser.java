package ua.training.controller.command.manager;

import org.apache.log4j.Logger;
import ua.training.controller.command.Command;
import ua.training.controller.security.Md5Encryption;
import ua.training.model.entity.Role;
import ua.training.model.entity.User;
import ua.training.model.service.UserService;
import ua.training.utils.constants.AttributesHolder;
import ua.training.utils.constants.UrlHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by andrii on 23.01.17.
 */
public class AddNewUser implements Command {
    private static Logger logger = Logger.getLogger(AddNewUser.class);
    UserService userService = UserService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = getUserEntityFromRequest(request);
        logger.info("NEW USER" + user.toString());
        userService.create(user);
        return UrlHolder.BASIC + UrlHolder.USERS;
    }

    private User getUserEntityFromRequest(HttpServletRequest request) {
        String firstName = request.getParameter(AttributesHolder.FIRST_NAME);
        String middleName = request.getParameter(AttributesHolder.MIDDLE_NAME);
        String lastName = request.getParameter(AttributesHolder.LAST_NAME);
        String password = request.getParameter(AttributesHolder.PASSWORD);
        String email = request.getParameter(AttributesHolder.EMAIL);
        Role role = Role.valueOf(request.getParameter(AttributesHolder.ROLE));
        return new User.Builder()
                .setFirstName(firstName)
                .setMiddleName(middleName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(Md5Encryption.encrypt(password))
                .setRole(role)
                .build();
    }
}
