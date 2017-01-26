package ua.training.controller.validator;

import ua.training.controller.i18n.ErrorsMessages;
import ua.training.model.entity.User;
import ua.training.utils.constants.AttributesHolder;

import java.util.regex.Pattern;

/**
 * Created by andrii on 26.01.17.
 */
public class UserValidator implements Validator<User> {
    private EmailValidator emailValidator;
    private Pattern passwordPattern;
    private Pattern namePattern;

    public UserValidator() {
        emailValidator = new EmailValidator();
        namePattern = Pattern.compile(RegExp.NAME);
        passwordPattern = Pattern.compile(RegExp.PASSWORD);
    }

    @Override
    public boolean validate(User user, Errors errors) {
        if (user != null) {
            if (!namePattern.matcher(user.getFirstName()).matches()) {
                reject(errors, AttributesHolder.FIRST_NAME, ErrorsMessages.FIRST_NAME_INVALID);
            }
            if (!namePattern.matcher(user.getMiddleName()).matches()) {
                reject(errors, AttributesHolder.MIDDLE_NAME, ErrorsMessages.MIDDLE_NAME_INVALID);
            }
            if (!namePattern.matcher(user.getLastName()).matches()) {
                reject(errors, AttributesHolder.LAST_NAME, ErrorsMessages.LAST_NAME_INVALID);
            }
            if (user.getRole() == null) {
                reject(errors, AttributesHolder.ROLE, ErrorsMessages.ROLE_INVALID);
            }
            emailValidator.validate(user.getEmail(), errors);
            if (!passwordPattern.matcher(user.getPassword()).matches()) {
                reject(errors, AttributesHolder.PASSWORD, ErrorsMessages.PASSWORD_INVALID);
            }
        } else {
            reject(errors, AttributesHolder.USER, ErrorsMessages.INVALID);
        }
        return !errors.hasError();
    }

    @Override
    public boolean validate(User user) {
        return !((namePattern.matcher(user.getFirstName()).matches()) ||
                (namePattern.matcher(user.getMiddleName()).matches()) ||
                (namePattern.matcher(user.getLastName()).matches()) ||
                (user.getRole() == null) ||
                (!emailValidator.validate(user.getEmail())) ||
                (!passwordPattern.matcher(user.getPassword()).matches()));
    }

    private void reject(Errors errors, String attribute, String message){
        errors.addMessage(attribute, message);
        errors.setResult(false);
    }
}
