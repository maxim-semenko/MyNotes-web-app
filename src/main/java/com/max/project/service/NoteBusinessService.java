package com.max.project.service;

import com.max.project.controller.command.RequestContext;
import com.max.project.entity.Note;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface NoteBusinessService {

    Note create(RequestContext requestContext);

    List<Note> selectAllByUserId(Long id);

    void removeAll(Long id);

}
