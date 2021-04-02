package com.max.project.service.impl;

import com.max.project.controller.command.RequestContext;
import com.max.project.dao.impl.NoteDao;
import com.max.project.entity.Note;
import com.max.project.entity.NoteStatusEnum;
import com.max.project.entity.User;
import com.max.project.exception.ValidatorException;
import com.max.project.service.EntityDaoService;
import com.max.project.service.NoteBusinessService;
import com.max.project.validator.NoteValidator;

import java.util.List;
import java.util.stream.Collectors;

public class NoteService implements EntityDaoService<Note>, NoteBusinessService {

    private static NoteService instance;
    private final NoteDao noteDao = NoteDao.getInstance();
    private final NoteValidator noteValidator = NoteValidator.getInstance();

    public static NoteService getInstance() {
        if (instance == null) {
            instance = new NoteService();
        }
        return instance;
    }

    @Override
    public Boolean insert(Note note) throws ValidatorException {
        if (noteValidator.validate(note)) {
            noteDao.insert(note);
        } else {
            throw new ValidatorException("Note validator exception");
        }
        return true;
    }

    @Override
    public Boolean update(Note note) throws ValidatorException {
        if (noteValidator.validate(note)) {
            noteDao.update(note);
        } else {
            throw new ValidatorException("Note validator exception");
        }
        return true;
    }

    @Override
    public Boolean remove(Long id) {
        return noteDao.removeById(id);
    }

    @Override
    public List<Note> selectAll() {
        return noteDao.selectAll();
    }

    @Override
    public Note selectById(Long id) {
        return noteDao.selectById(id);
    }

    @Override
    public Note create(RequestContext requestContext) {
        return Note.builder()
                .id(Long.parseLong(requestContext.getParamMap().get("id")))
                .name(requestContext.getParamMap().get("name"))
                .decryption(requestContext.getParamMap().get("decryption"))
                .createdTime(requestContext.getParamMap().get("createdTime"))
                .noteStatus(NoteStatusEnum.WAITING)
                .user((User) requestContext.getHttpSession().getAttribute("user"))
                .build();
    }

    /**
     * Method that selects all {@link Note} by {@link User} id.
     *
     * @param id {@link Long}
     * @return {@link List<Note>}
     */
    @Override
    public List<Note> selectAllByUserId(Long id) {
//        return null;
        return selectAll().stream().filter(note -> note.getUser().getId().equals(id))
//                .peek(note -> note.setDecryption(note.getDecryption().replaceAll("\n","<br>")))
                .collect(Collectors.toList());
    }
}
