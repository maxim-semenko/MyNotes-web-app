package com.max.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * {@link AbstractResultSet} interface that has one method that
 * gets {@link ResultSet} from database, parse it and return {@link T}.
 *
 * @param <T> any POJO class
 * @author Maxim Semenko
 * @version 0.0.1
 */

public interface AbstractResultSet<T> {

    T execute(ResultSet resultSet) throws SQLException;

}
