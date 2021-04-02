package com.max.project.service;

import com.max.project.exception.ValidatorException;

import java.util.List;

public interface EntityDaoService<T> {

    Boolean insert(T t) throws ValidatorException;

    Boolean update(T t) throws ValidatorException;

    Boolean remove(Long id);

    List<T> selectAll();

    T selectById(Long id);

}
