package com.max.project.controller.command.impl;

import com.max.project.context.PathToPages;
import com.max.project.controller.command.Command;
import com.max.project.controller.command.RequestContext;
import com.max.project.controller.command.ResponseContext;
import com.max.project.service.impl.UserService;

public class AllUsersPageCommand implements Command {
    @Override
    public ResponseContext execute(RequestContext requestContext) {
        requestContext.setAttribute("allUsers", UserService.getInstance().selectAll());
        return new ResponseContextImpl(PathToPages.ALL_USERS_PAGE, ResponseContext.ResponseType.FORWARD);
    }
}
