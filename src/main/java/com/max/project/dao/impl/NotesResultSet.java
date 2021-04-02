package com.max.project.dao.impl;

import com.max.project.dao.AbstractResultSet;
import com.max.project.entity.Note;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NotesResultSet implements AbstractResultSet<Note> {
    @Override
    public Note execute(ResultSet resultSet) throws SQLException {
        return null;
    }
}
