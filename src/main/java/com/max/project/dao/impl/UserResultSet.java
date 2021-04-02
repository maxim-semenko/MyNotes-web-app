package com.max.project.dao.impl;

import com.max.project.dao.AbstractResultSet;
import com.max.project.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserResultSet implements AbstractResultSet<User> {

    private static UserResultSet instance;

    public static UserResultSet getInstance() {
        if (instance == null) {
            instance = new UserResultSet();
        }
        return instance;
    }

    @Override
    public User execute(ResultSet resultSet) throws SQLException {
        return null;
    }
}
