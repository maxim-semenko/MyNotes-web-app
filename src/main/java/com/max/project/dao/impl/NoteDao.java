package com.max.project.dao.impl;

import com.max.project.dao.AbstractDao;
import com.max.project.entity.Note;
import com.max.project.entity.User;
import com.max.project.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class NoteDao implements AbstractDao<Note> {

    private static NoteDao instance;
    private Session currentSession;
    private Transaction transaction;

    public static NoteDao getInstance() {
        if (instance == null) {
            instance = new NoteDao();
        }
        return instance;
    }

    /**
     * Method that opens {@link Session} and {@link Transaction}.
     */
    private void openCurrentSessionWithTransaction() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
        transaction = currentSession.beginTransaction();
    }

    /**
     * Method that closes {@link Session} and {@link Transaction}.
     */
    private void closeCurrentSessionWithTransaction() {
        transaction.commit();
        currentSession.close();
    }

    @Override
    public Boolean insert(Note note) {
        openCurrentSessionWithTransaction();
        currentSession.save(note);
        closeCurrentSessionWithTransaction();
        return true;
    }

    @Override
    public Boolean update(Note note) {
        openCurrentSessionWithTransaction();
        currentSession.update(note);
        closeCurrentSessionWithTransaction();
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Note> selectAll() {
        return HibernateUtil.getSessionFactory().openSession().createQuery("from Note").list();
    }

    @Override
    public Note selectById(Long id) {
        return HibernateUtil.getSessionFactory().openSession().get(Note.class, id);
    }

    @Override
    public List<Note> selectByCriteria(Note note) {
        return null;
    }

    @Override
    public Boolean removeById(Long id) {
        openCurrentSessionWithTransaction();
        currentSession.remove(currentSession.get(Note.class, id));
        closeCurrentSessionWithTransaction();
        return true;
    }
}
