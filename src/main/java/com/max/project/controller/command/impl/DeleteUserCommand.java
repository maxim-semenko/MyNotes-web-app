package com.max.project.controller.command.impl;

import com.max.project.context.PathToPages;
import com.max.project.controller.command.Command;
import com.max.project.controller.command.RequestContext;
import com.max.project.controller.command.ResponseContext;
import com.max.project.entity.User;
import com.max.project.service.impl.NoteService;
import com.max.project.service.impl.UserService;

public class DeleteUserCommand implements Command {
    @Override
    public ResponseContext execute(RequestContext requestContext) {
        User user = (User) (requestContext.getHttpSession().getAttribute("user"));
        NoteService.getInstance().removeAll(user.getId());
        UserService.getInstance().remove(user.getId());
        return new ResponseContextImpl(PathToPages.HOME_REDIRECT, ResponseContext.ResponseType.REDIRECT);
    }
}
