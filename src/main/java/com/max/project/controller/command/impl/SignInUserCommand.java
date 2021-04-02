package com.max.project.controller.command.impl;

import com.max.project.context.PathToPages;
import com.max.project.context.config.AdminConfiguration;
import com.max.project.controller.command.Command;
import com.max.project.controller.command.RequestContext;
import com.max.project.controller.command.ResponseContext;
import com.max.project.entity.User;
import com.max.project.service.impl.UserService;
import com.max.project.util.PasswordSecurityUtil;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

public class SignInUserCommand implements Command {

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        HttpSession session = requestContext.getHttpSession();

        User user = AdminConfiguration.getInstance().getAdmin();
        String login = requestContext.getParamMap().get("login");
        String password = PasswordSecurityUtil.doHashing(requestContext.getParamMap().get("password"));
        System.out.println("PASSWORD = " + password);

        if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
            session.setMaxInactiveInterval(1000);
            session.setAttribute("user", user);
            return new ResponseContextImpl(PathToPages.ADMIN_CABINET_PAGE_REDIRECT, ResponseContext.ResponseType.REDIRECT);
        } else {
            Optional<User> optionalUser = UserService.getInstance().selectByCriteria(
                    User.builder()
                            .login(login)
                            .password(password)
                            .build());

            if (optionalUser.isPresent()) {
                session.setMaxInactiveInterval(1000);
                session.setAttribute("user", optionalUser.get());
                System.out.println("EXISTS");
                return new ResponseContextImpl(PathToPages.USER_CABINET_PAGE_REDIRECT, ResponseContext.ResponseType.REDIRECT);
            }
        }
        session.setAttribute("userNotFound", true);
        return new ResponseContextImpl(PathToPages.SIGN_IN_PAGE_REDIRECT, ResponseContext.ResponseType.REDIRECT);
    }
}
