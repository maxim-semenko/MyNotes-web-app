package com.max.project.validator;

import com.max.project.exception.ValidatorException;

import java.util.function.Predicate;

public class DecryptionValidator implements Validator<String> {

    public static DecryptionValidator instance;
    private final int minLength = 2;
    private final int maxLength = 255;

    public static DecryptionValidator getInstance() {
        if (instance == null) {
            instance = new DecryptionValidator();
        }
        return instance;
    }


    @Override
    public Boolean validate(String input) throws ValidatorException {
        Predicate<String> stringPredicate = str -> (
                !str.isEmpty() & str.length() < maxLength & str.length() > minLength);
        return stringPredicate.test(input);
    }
}
