package com.max.project.context.config;


import com.max.project.entity.User;
import com.max.project.util.AdminPropertiesReaderUtil;
import com.max.project.util.PasswordSecurityUtil;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

/**
 * Class Admin, which has admin opportunity to control web app.
 *
 * @author Maxim Semenko
 * @version 0.0.1
 */

@Getter
@ToString
@Log4j2
public final class AdminConfiguration {

    private static AdminConfiguration instance;

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String EMAIL = "email";
    private static final String FIRSTNAME = "firstname";
    private static final String LASTNAME = "lastname";
    private static final String ROLE_ID = "roleId";

    private String login;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
    private int roleId;

    public static AdminConfiguration getInstance() {
        if (instance == null) {
            instance = init();
        }
        return instance;
    }

    /**
     * Method performs initialization configurations of data base.
     *
     * @return singleton instance of class
     */
    private static AdminConfiguration init() {
        AdminConfiguration instance = new AdminConfiguration();

        log.info("Start email configuration");
        instance.login = AdminPropertiesReaderUtil.resourceBundle.getString(LOGIN);
        instance.password = AdminPropertiesReaderUtil.resourceBundle.getString(PASSWORD);
        instance.email = AdminPropertiesReaderUtil.resourceBundle.getString(EMAIL);
        instance.firstname = AdminPropertiesReaderUtil.resourceBundle.getString(FIRSTNAME);
        instance.lastname = AdminPropertiesReaderUtil.resourceBundle.getString(LASTNAME);
        instance.roleId = Integer.parseInt(AdminPropertiesReaderUtil.resourceBundle.getString(ROLE_ID));

        return instance;
    }

    /**
     * Method that build and return {@link User} admin.
     *
     * @return {@link User} admin
     */
    public User getAdmin() {
        return User.builder().login(login).password(PasswordSecurityUtil.doHashing(password)).email(email).build();
    }

}

