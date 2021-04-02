package com.max.project.validator;

import com.max.project.entity.User;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Validator class that checks right of {@link User} data.
 *
 * @author Maxim Semenko
 * @version 0.0.1
 */

public class UserValidator implements Validator<User> {

    private static UserValidator instance;

    public static UserValidator getInstance() {
        if (instance == null) {
            instance = new UserValidator();
        }
        return instance;
    }

    /**
     * Method that checks, if all input data of {@link User} are valid.
     *
     * @param user {@link User}
     * @return {@link Boolean} true/false
     */
    @Override
    public Boolean validate(final User user) {
        return LoginValidator.getInstance().validate(user.getLogin())
                && PasswordValidator.getInstance().validate(user.getPassword())
                && NameValidator.getInstance().validate(user.getFirstname())
                && NameValidator.getInstance().validate(user.getLastname())
                && EmailValidator.getInstance().validate(user.getEmail());
    }


}
