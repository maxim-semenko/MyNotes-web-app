package com.max.project.validator;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

/**
 * Validator class that checks right of {@link String} data.
 *
 * @author Maxim Semenko
 * @version 0.0.1
 */

public class StringValidator implements Validator<String> {

    private static StringValidator instance;
    private final int maxLength = 25;
    private final int minLength = 2;

    public static StringValidator getInstance() {
        if (instance == null) {
            instance = new StringValidator();
        }
        return instance;
    }

    /**
     * Method checks, if {@link String} input not empty and have right length.
     *
     * @param input {@link String} user data
     * @return {@link Boolean} true/false
     */
    @Override
    public Boolean validate(final String input) {
        Predicate<String> stringPredicate = str -> (
                !str.isEmpty() & str.length() < maxLength & str.length() > minLength);
        return stringPredicate.test(input);
    }
}
