package com.max.project.controller.command.impl;

import com.max.project.context.PathToPages;
import com.max.project.controller.command.Command;
import com.max.project.controller.command.RequestContext;
import com.max.project.controller.command.ResponseContext;
import com.max.project.entity.Note;
import com.max.project.entity.NoteStatusEnum;
import com.max.project.entity.User;
import com.max.project.exception.ValidatorException;
import com.max.project.service.impl.NoteService;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddNoteCommand implements Command {
    @Override
    public ResponseContext execute(RequestContext requestContext) {
        Note note = Note.builder()
                .name(requestContext.getParamMap().get("name"))
                .decryption(requestContext.getParamMap().get("decryption"))
                .user((User) requestContext.getHttpSession().getAttribute("user"))
                .noteStatus(NoteStatusEnum.WAITING)
                .createdTime(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Calendar.getInstance().getTime()))
                .build();
        try {
            NoteService.getInstance().insert(note);
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
        return new ResponseContextImpl(PathToPages.USER_CABINET_PAGE_REDIRECT, ResponseContext.ResponseType.REDIRECT);
    }
}
