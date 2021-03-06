package ua.training.controller.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by andrii on 21.01.17.
 */
public interface Command {
    String execute(HttpServletRequest request,
                   HttpServletResponse response)
            throws ServletException, IOException;

}