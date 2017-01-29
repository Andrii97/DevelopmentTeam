package ua.training.controller;

import ua.training.controller.command.*;
import ua.training.controller.command.customer.*;
import ua.training.controller.command.developer.*;
import ua.training.controller.command.manager.*;
import ua.training.utils.constants.PagesHolder;
import ua.training.utils.constants.PathsHolder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by andrii on 27.01.17.
 */
public class CommandHolder {
    public static final String DELIMITER = ":";
    private static final String GET = "GET" + DELIMITER;
    private static final String POST = "POST" + DELIMITER;

    private Map<String , Command> commands = new HashMap<>();

    public CommandHolder() {
        initCommands();
    }

    private void initCommands() {
        commands.put(GET + PathsHolder.LOGIN_PREFIX, new GetLoginPage());
        commands.put(POST + PathsHolder.LOGIN_PREFIX,  new Login());

        commands.put(GET + PathsHolder.CUSTOMER_PREFIX, new GetCustomerHomePage());
        commands.put(GET + PathsHolder.MANAGER_PREFIX, new GetManagerHomePage());
        commands.put(GET + PathsHolder.DEVELOPER_PREFIX, new GetDeveloperHomePage());

        commands.put(GET + PathsHolder.LOGOUT_PREFIX,  new Logout());
        commands.put(POST + PathsHolder.SIGN_UP,  new SignUp());
        commands.put(GET + PathsHolder.SIGN_UP,  new GetSignUpPage());

        // customer's
        commands.put(GET + PathsHolder.ADD_STATEMENT_OF_WORK,
                new GetCreateStatementOfWork());
        commands.put(POST + PathsHolder.ADD_STATEMENT_OF_WORK, new CreateStatementOfWork());
        commands.put(GET + PathsHolder.STATEMENT_OF_WORK, new GetStatementOfWork());
        commands.put(GET + PathsHolder.STATEMENTS_OF_WORK_BY_CUSTOMER,
                new GetStatementsOfWorkByCustomer());
        commands.put(POST + PathsHolder.STATEMENT_OF_WORK, new UpdateStatementOfWork());
        commands.put(GET + PathsHolder.DELETE_STATEMENT_OF_WORK, new DeleteStatementOfWork()); // todo must be post?
        commands.put(POST + PathsHolder.ADD_TASK, new AddTaskForStatementOfWork());

        // manager's
        commands.put(GET + PathsHolder.USERS, new GetUsers());
        commands.put(GET + PathsHolder.ADD_USER, new GetAddNewUserPage());
        commands.put(POST + PathsHolder.ADD_USER, new AddNewUser());
        commands.put(GET + PathsHolder.TASKS, new GetTasksByDeveloper());
    }

    Command getCommand(String commandKey) {
        return commands.getOrDefault(commandKey, (req , resp)-> PagesHolder.PAGE_NOT_FOUND);
    }
}
