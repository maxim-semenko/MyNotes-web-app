package com.max.project.controller.command.impl;

import com.max.project.context.PathToPages;
import com.max.project.controller.command.Command;
import com.max.project.controller.command.RequestContext;
import com.max.project.controller.command.ResponseContext;
import com.max.project.service.impl.NoteService;

public class DeleteNoteCommand implements Command {

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        NoteService.getInstance().remove(Long.parseLong(requestContext.getParamMap().get("id")));
        return new ResponseContextImpl(PathToPages.USER_CABINET_PAGE_REDIRECT, ResponseContext.ResponseType.REDIRECT);
    }
}
