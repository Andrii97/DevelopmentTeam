package ua.training.controller.validator;

/**
 * Created by andrii on 26.01.17.
 */
public class RegExp {
    public static final String EMAIL =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final String NAME = "^[\\p{L}\\.'\\-]+$";
    public static final String PASSWORD = "[^\\s]{4,50}";
    public static final String NUMBER = "\\d+";
}
