package ua.training.controller.validator;

import ua.training.controller.i18n.ErrorsMessages;
import ua.training.utils.constants.AttributesHolder;

import java.util.regex.Pattern;

/**
 * Created by andrii on 25.01.17.
 */
public class EmailValidator implements Validator<String> {
    private Pattern emailPattern;

    public EmailValidator() {
        emailPattern = Pattern.compile(RegExp.EMAIL);
    }

    public EmailValidator(String emailRegex) {
        emailPattern = Pattern.compile(emailRegex);
    }

    @Override
    public boolean validate(String email, Errors errors) {
        if (!validate(email)) {
            errors.setResult(false);
            errors.addMessage(AttributesHolder.EMAIL, ErrorsMessages.EMAIL_INVALID);
            return errors.getResult();
        }
        return true;
    }

    @Override
    public boolean validate(String email) {
        return emailPattern.matcher(email).matches();
    }
}
