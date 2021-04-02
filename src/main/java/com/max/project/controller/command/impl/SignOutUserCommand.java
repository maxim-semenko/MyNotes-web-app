package com.max.project.controller.command.impl;

import com.max.project.context.PathToPages;
import com.max.project.controller.command.Command;
import com.max.project.controller.command.RequestContext;
import com.max.project.controller.command.ResponseContext;

public class SignOutUserCommand implements Command {
    @Override
    public ResponseContext execute(RequestContext requestContext) {
        requestContext.getHttpSession().setAttribute("user", null);
        requestContext.getHttpSession().invalidate();
        return new ResponseContextImpl(PathToPages.USER_CABINET_PAGE_REDIRECT, ResponseContext.ResponseType.REDIRECT);
    }
}
