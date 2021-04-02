package com.max.project.entity;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum NoteStatusEnum {
    NULL(0),
    COMPLETED(1),
    WAITING(2),
    FAILED(3);

    private final Integer id;

    NoteStatusEnum(Integer id) {
        this.id = id;
    }

    public static NoteStatusEnum getById(Integer id) {
        for(NoteStatusEnum e : values()) {
            if(e.getId().equals(id)) return e;
        }
        return null;
    }
}
