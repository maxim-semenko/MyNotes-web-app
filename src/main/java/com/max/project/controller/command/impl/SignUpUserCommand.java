package com.max.project.controller.command.impl;

import com.max.project.context.PathToPages;
import com.max.project.controller.command.Command;
import com.max.project.controller.command.RequestContext;
import com.max.project.controller.command.ResponseContext;
import com.max.project.entity.User;
import com.max.project.entity.UserRoleEnum;
import com.max.project.exception.ValidatorException;
import com.max.project.service.impl.UserService;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SignUpUserCommand implements Command {

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        UserService userService = UserService.getInstance();
        User user = buildUser(requestContext);
        boolean isError = false;

        if (userService.isExistLogin(user.getLogin())) {
            requestContext.setAttribute("isExistLogin", true);
            isError = true;
        }

        if (userService.isExistEmail(user.getEmail())) {
            requestContext.setAttribute("isExistEmail", true);
            isError = true;
        }

        if (!isError) {
            try {
                userService.insert(user);
                return new ResponseContextImpl(PathToPages.SIGN_IN_PAGE_REDIRECT, ResponseContext.ResponseType.REDIRECT);
            } catch (ValidatorException e) {
                log.error("Validator exception" + e);
            }
        }
        return new ResponseContextImpl(PathToPages.SIGN_UP_PAGE, ResponseContext.ResponseType.FORWARD);
    }

    private User buildUser(RequestContext requestContext) {
        return User.builder()
                .firstname(requestContext.getParamMap().get("firstname"))
                .lastname(requestContext.getParamMap().get("lastname"))
                .email(requestContext.getParamMap().get("email"))
                .login(requestContext.getParamMap().get("login"))
                .password(requestContext.getParamMap().get("password"))
                .roleId(UserRoleEnum.CLIENT)
                .build();
    }
}