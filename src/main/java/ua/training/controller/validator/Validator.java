package ua.training.controller.validator;

/**
 * Created by andrii on 25.01.17.
 */
public interface Validator<E> {
    boolean validate(E t, Errors errors);
    boolean validate(E t);
}
