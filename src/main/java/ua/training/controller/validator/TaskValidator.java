package ua.training.controller.validator;

import ua.training.model.entity.Task;

/**
 * Created by andrii on 29.01.17.
 */
public class TaskValidator implements Validator<Task> {

    @Override
    public boolean validate(Task task, Errors errors) {
        return false; // todo
    }

    @Override
    public boolean validate(Task task) {
        return !(task.getTaskRequirements().isEmpty() ||
                task.getName() == null);
    }
}
