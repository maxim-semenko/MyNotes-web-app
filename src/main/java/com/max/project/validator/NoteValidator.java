package com.max.project.validator;

import com.max.project.entity.Note;
import com.max.project.exception.ValidatorException;

public class NoteValidator implements Validator<Note> {

    private static NoteValidator instance;

    public static NoteValidator getInstance() {
        if (instance == null) {
            instance = new NoteValidator();
        }
        return instance;
    }

    @Override
    public Boolean validate(Note node) throws ValidatorException {
        return NameValidator.getInstance().validate(node.getName())
                && DecryptionValidator.getInstance().validate(node.getDecryption());
    }
}
