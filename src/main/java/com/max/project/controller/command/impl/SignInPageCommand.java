package com.max.project.controller.command.impl;

import com.max.project.context.PathToPages;
import com.max.project.controller.command.Command;
import com.max.project.controller.command.RequestContext;
import com.max.project.controller.command.ResponseContext;

public class SignInPageCommand implements Command {
    @Override
    public ResponseContext execute(RequestContext requestContext) {
        return new ResponseContextImpl(PathToPages.SIGN_IN_PAGE, ResponseContext.ResponseType.FORWARD);
    }
}
