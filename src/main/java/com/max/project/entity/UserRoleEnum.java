package com.max.project.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Class enum that contain the role of {@link User}.
 *
 * @author Maxim Semenko
 * @version 0.0.1
 */

@Getter
@AllArgsConstructor
public enum UserRoleEnum {
    NULL, ADMIN, CLIENT;

//    private final Integer id;
//
//    public static UserRoleEnum getById(Integer id) {
//        for(UserRoleEnum e : values()) {
//            if(e.getId().equals(id)) return e;
//        }
//        return null;
//    }

}

