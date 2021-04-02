package com.max.project.controller.command.impl;

import com.max.project.context.PathToPages;
import com.max.project.controller.command.Command;
import com.max.project.controller.command.RequestContext;
import com.max.project.controller.command.ResponseContext;
import com.max.project.exception.ValidatorException;
import com.max.project.service.impl.NoteService;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class EditNodeCommand implements Command {
    @Override
    public ResponseContext execute(RequestContext requestContext) {
        try {
            NoteService.getInstance().update(NoteService.getInstance().create(requestContext));
        } catch (ValidatorException e) {
            log.error("Can't update note: " + e);
        }
        return new ResponseContextImpl(PathToPages.USER_CABINET_PAGE_REDIRECT, ResponseContext.ResponseType.REDIRECT);
    }
}
