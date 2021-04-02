package com.max.project.dao;

import com.max.project.entity.BaseEntity;

import java.util.List;

public interface AbstractDao<T extends BaseEntity> {

    Boolean insert(T t);

    Boolean update(T t);

    List<T> selectAll();

    T selectById(Long id);

    List<T> selectByCriteria(T t);

    Boolean removeById(Long id);

}
