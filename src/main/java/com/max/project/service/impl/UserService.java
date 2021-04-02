package com.max.project.service.impl;

import com.max.project.dao.impl.UserDao;
import com.max.project.entity.User;
import com.max.project.exception.ValidatorException;
import com.max.project.service.EntityDaoService;
import com.max.project.util.PasswordSecurityUtil;
import com.max.project.service.UserBusinessService;
import com.max.project.validator.UserValidator;

import java.util.List;
import java.util.Optional;

public class UserService implements EntityDaoService<User>, UserBusinessService {

    private static UserService instance;
    private final UserDao userDao = UserDao.getInstance();
    private static final UserValidator userValidator = UserValidator.getInstance();

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    /**
     * Method that inserts {@link User} to database.
     *
     * @param user {@link User}
     * @return {@link Boolean}
     * @throws ValidatorException if user's data invalid.
     */
    @Override
    public Boolean insert(User user) throws ValidatorException {
        if (userValidator.validate(user)) {
            user.setPassword(PasswordSecurityUtil.doHashing(user.getPassword()));
            userDao.insert(user);
        } else {
            throw new ValidatorException("User validator exception");
        }
        return true;
    }

    /**
     * Method that updates {@link User} in database.
     *
     * @param user {@link User}
     * @return {@link Boolean}
     * @throws ValidatorException if user's data invalid
     */
    @Override
    public Boolean update(User user) throws ValidatorException {
        if (userValidator.validate(user)) {
            userDao.update(user);
        } else {
            throw new ValidatorException("User validator exception");
        }
        return true;
    }

    @Override
    public Boolean remove(Long id) {
        return userDao.removeById(id);
    }

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    @Override
    public User selectById(Long id) {
        return userDao.selectById(id);
    }

    /**
     * Method that checks all {@link User} logins.
     *
     * @param login {@link String}
     * @return {@link Boolean}
     */
    @Override
    public Boolean isExistLogin(String login) {
        return selectAll().stream().anyMatch(user -> user.getLogin().equals(login));
    }

    /**
     * Method that checks all {@link User} emails.
     *
     * @param email {@link String}
     * @return {@link Boolean}
     */
    @Override
    public Boolean isExistEmail(String email) {
        System.out.println("service email " + email);

        return selectAll().stream().anyMatch(user -> user.getEmail().equals(email));
    }

    @Override
    public Optional<User> selectByCriteria(User user) {
        if (!userDao.selectByCriteria(user).isEmpty()) {
            return Optional.of(userDao.selectByCriteria(user).get(0));
        }
        return Optional.empty();
    }

    @Override
    public List<User> selectAllByCriteria(User user) {
        return userDao.selectByCriteria(user);
    }
}
