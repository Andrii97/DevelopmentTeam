package ua.training.controller.validator;

import ua.training.model.entity.DeveloperHasTask;

/**
 * Created by andrii on 30.01.17.
 */
public class DeveloperHasTaskValidator implements Validator<DeveloperHasTask> {
    @Override
    public boolean validate(DeveloperHasTask developerHasTask, Errors errors) {
        return false;
    }

    @Override
    public boolean validate(DeveloperHasTask developerHasTask) {
        return false;
    }
}
