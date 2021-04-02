package com.max.project.service;

import com.max.project.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserBusinessService {

    Boolean isExistLogin(String login);

    Boolean isExistEmail(String login);

    Optional<User> selectByCriteria(User user);

    List<User> selectAllByCriteria(User user);


}
