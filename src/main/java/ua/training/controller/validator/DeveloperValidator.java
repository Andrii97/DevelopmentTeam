package ua.training.controller.validator;

import ua.training.controller.i18n.ErrorsMessages;
import ua.training.model.entity.Developer;
import ua.training.utils.constants.AttributesHolder;

/**
 * Created by andrii on 30.01.17.
 */
public class DeveloperValidator implements Validator<Developer> {

    @Override
    public boolean validate(Developer developer, Errors errors) {
        if (developer != null) {
            if (developer.getQualification() == null) {
                reject(errors, AttributesHolder.QUALIFICATION,
                        ErrorsMessages.QUALIFICATION_INVALID);
            }
            if (developer.getUser() == null) {
                reject(errors, AttributesHolder.USER, ErrorsMessages.INVALID);
            }
        } else {
            reject(errors, AttributesHolder.DEVELOPER, ErrorsMessages.INVALID);
        }
        return !errors.hasError();
    }

    @Override
    public boolean validate(Developer developer) {
        return !(developer.getQualification() == null
                && developer.getUser() == null);
    }

    private void reject(Errors errors, String attribute, String message){
        errors.addMessage(attribute, message);
        errors.setResult(false);
    }
}
