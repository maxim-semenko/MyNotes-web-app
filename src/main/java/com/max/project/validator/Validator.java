package com.max.project.validator;


import com.max.project.exception.ValidatorException;

/**
 * Interface that has one method, which get {@link T}
 * some object and check validate.
 *
 * @param <T> any object
 */

public interface Validator<T> {

    Boolean validate(T t) throws ValidatorException;
}

