package ua.training.controller.validator;

import ua.training.controller.i18n.ErrorsMessages;
import ua.training.utils.constants.AttributesHolder;

import java.util.regex.Pattern;

/**
 * Created by andrii on 29.01.17.
 */
public class NumberValidator implements Validator<String> {
    private Pattern numberPattern;

    public NumberValidator() {
        numberPattern = Pattern.compile(RegExp.NUMBER);
    }

    @Override
    public boolean validate(String number, Errors errors) {
        if (!validate(number)) {
            errors.setResult(false);
            errors.addMessage(AttributesHolder.NUMBER, ErrorsMessages.NUMBER_INVALID);
            return errors.getResult();
        }
        return true;
    }

    @Override
    public boolean validate(String number) {
        return numberPattern.matcher(number).matches();
    }
}
