package com.max.project.validator;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

/**
 * Validator class that checks right of {@link String} password.
 *
 * @author Maxim Semenko
 * @version 0.0.1
 */

public class PasswordValidator implements Validator<String> {

    private static PasswordValidator instance;

    public static PasswordValidator getInstance() {
        if (instance == null) {
            instance = new PasswordValidator();
        }
        return instance;
    }

    /**
     * Method checks, if {@link String} password has right length.
     *
     * @param input {@link String} user's password
     * @return {@link Boolean} true/false
     */
    @Override
    public Boolean validate(final String input) {
        Predicate<String> stringPredicate = str -> (str.length() > 7 && str.length() < 256);
        return stringPredicate.test(input);
    }
}
