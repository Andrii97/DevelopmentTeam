package ua.training.controller.command.manager;

import ua.training.controller.command.Command;
import ua.training.utils.constants.PagesHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by andrii on 23.01.17.
 */
public class GetManagerHomePage implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return PagesHolder.HOME_PAGE;
    }
}
