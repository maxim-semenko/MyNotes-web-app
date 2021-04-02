package com.max.project.validator;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

/**
 * Validator class that checks right of {@link String} name.
 *
 * @author Maxim Semenko
 * @version 0.0.1
 */

public class NameValidator implements Validator<String> {

    private static NameValidator instance;
    private final static String name_regex_pattern = "^([А-Я][а-я]{1,25}|[A-Z][a-z]{1,25})$";

    public static NameValidator getInstance() {
        if (instance == null) {
            instance = new NameValidator();
        }
        return instance;
    }

    /**
     * Method checks, if {@link String} name not empty and looks like match pattern.
     *
     * @param input {@link String} user's password
     * @return {@link Boolean} true/false
     */
    @Override
    public Boolean validate(final String input) {
        Predicate<String> stringPredicate = str -> (
                StringValidator.getInstance().validate(str));
        return stringPredicate.test(input);
    }
}
