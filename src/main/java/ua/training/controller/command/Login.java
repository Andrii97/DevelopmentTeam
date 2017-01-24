package ua.training.controller.command;

import org.apache.commons.codec.digest.DigestUtils;

import ua.training.model.entity.Role;
import ua.training.model.entity.User;
import ua.training.model.service.DeveloperService;
import ua.training.model.service.UserService;
import ua.training.utils.constants.AttributesHolder;
import ua.training.utils.constants.PagesHolder;
import ua.training.utils.constants.UrlHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by andrii on 21.01.17.
 */
public class Login implements Command {

    public static final String PARAM_LOGIN = "login";

    public static final String PARAM_PASSWORD ="password";

    private UserService userService = UserService.getInstance();

    private DeveloperService developerService = DeveloperService.getInstance();

    private Map<Role, String> afterLoginPathToGoByRole = new HashMap<Role, String>() {{
        put(Role.CUSTOMER, UrlHolder.CUSTOMER_URL);// PagesHolder.CUSTOMER_HOME_PAGE);
        put(Role.MANAGER, UrlHolder.MANAGER_URL);// PagesHolder.MANAGER_HOME_PAGE);
        put(Role.DEVELOPER, UrlHolder.DEVELOPER_URL); // PagesHolder.DEVELOPER_HOME_PAGE);
    }};

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pageToGo = PagesHolder.LOGIN_PAGE;
        String email = request.getParameter(PARAM_LOGIN);
        String password = request.getParameter(PARAM_PASSWORD);
        if( email != null && password != null ){
            Optional<User> user;
            password = encrypt(password);
            user = userService.login(email, password);
            user.ifPresent(person -> request
                    .getSession()
                    .setAttribute(AttributesHolder.USER, person));
            Role role = user.map(User::getRole).orElseThrow(RuntimeException::new);
            pageToGo = afterLoginPathToGoByRole.get(role);
        }
        return pageToGo;
    }

    public String encrypt(String st) {
        return DigestUtils.md5Hex(st);
    }
}
