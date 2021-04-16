package com.max.project.controller.command.impl;

import com.max.project.context.PathToPages;
import com.max.project.controller.command.Command;
import com.max.project.controller.command.RequestContext;
import com.max.project.controller.command.ResponseContext;
import com.max.project.entity.User;
import com.max.project.exception.ValidatorException;
import com.max.project.service.impl.UserService;
import com.max.project.util.PasswordSecurityUtil;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class EditUserCommand implements Command {
    @Override
    public ResponseContext execute(RequestContext requestContext) {
        User oldUser = (User) requestContext.getHttpSession().getAttribute("user");
        User newUser = User.builder()
                .login(requestContext.getParamMap().get("login"))
                .firstname(requestContext.getParamMap().get("firstname"))
                .lastname(requestContext.getParamMap().get("lastname"))
                .email(requestContext.getParamMap().get("email"))
                .roleId(oldUser.getRoleId())
                .noteList(oldUser.getNoteList())
                .password(oldUser.getPassword())
                .id(oldUser.getId())
                .build();

        UserService userService = UserService.getInstance();
        boolean isError = false;


        if (!requestContext.getParamMap().get("password").equals(oldUser.getPassword())) {
            newUser.setPassword(PasswordSecurityUtil.doHashing(requestContext.getParamMap().get("password")));
        }
        if (!newUser.getLogin().equals(oldUser.getLogin())) {
            if (userService.isExistLogin(newUser.getLogin())) {
                requestContext.setAttribute("isExistLogin", true);
                isError = true;
            }
        }
        if (!newUser.getEmail().equals(oldUser.getEmail())) {
            if (userService.isExistEmail(newUser.getEmail())) {
                requestContext.setAttribute("isExistEmail", true);
                isError = true;
            }
        }

        if (!isError) {
            try {
                UserService.getInstance().update(newUser);
                requestContext.getHttpSession().setAttribute("user", newUser);
                requestContext.setAttribute("isEditOk", true);
            } catch (ValidatorException e) {
                log.error("Can't update user: " + e);
            }
        }
        return new ResponseContextImpl(PathToPages.USER_EDIT_PAGE, ResponseContext.ResponseType.FORWARD);
    }
}
