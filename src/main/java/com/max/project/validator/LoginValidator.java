package com.max.project.validator;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

/**
 * Validator class that checks right of {@link String} user login.
 *
 * @author Maxim Semenko
 * @version 0.0.1
 */

public class LoginValidator implements Validator<String> {

    private static LoginValidator instance;
    private final String login_regex_pattern = "^[a-zA-Z0-9]+$";


    public static LoginValidator getInstance() {
        if (instance == null) {
            instance = new LoginValidator();
        }
        return instance;
    }

    /**
     * Method checks, if {@link String} input looks like match pattern.
     *
     * @param input {@link String} user's login
     * @return {@link Boolean} true/false
     */
    @Override
    public Boolean validate(final String input) {
        Predicate<String> stringPredicate = str -> (
                StringValidator.getInstance().validate(str) & str.matches(login_regex_pattern));
        return stringPredicate.test(input);
    }
}
