package com.max.project.dao.impl;

import com.max.project.dao.AbstractDao;
import com.max.project.entity.User;
import com.max.project.util.HibernateUtil;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Log4j2
public class UserDao implements AbstractDao<User> {

    private static UserDao instance;
    private Session currentSession;
    private Transaction transaction;

    public static UserDao getInstance() {
        if (instance == null) {
            instance = new UserDao();
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

    /**
     * Method that inserts {@link User} to database.
     *
     * @param user {@link User}
     * @return {@link Boolean}
     */
    @Override
    public Boolean insert(User user) {
        openCurrentSessionWithTransaction();
        currentSession.save(user);
        closeCurrentSessionWithTransaction();
        return true;
    }

    /**
     * Method that updates {@link User} in database.
     *
     * @param user {@link User}
     * @return {@link Boolean}
     */
    @Override
    public Boolean update(User user) {
        openCurrentSessionWithTransaction();
        currentSession.update(user);
        closeCurrentSessionWithTransaction();
        return true;
    }

    /**
     * Method that select all {@link User} from database.
     *
     * @return {@link List<User>}
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<User> selectAll() {
        return HibernateUtil.getSessionFactory().openSession().createQuery("from User").list();
    }

    /**
     * Method that select {@link User} from database by id.
     *
     * @param id {@link Long}
     * @return {@link User}
     */
    @Override
    public User selectById(Long id) {
        return HibernateUtil.getSessionFactory().openSession().get(User.class, id);
    }

    @Override
    public List<User> selectByCriteria(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);

        List<Predicate> predicateList = new ArrayList<>();
        Optional.ofNullable(user.getId()).ifPresent(predicate -> predicateList.add(builder.equal(root.get("id"), user.getId())));
        Optional.ofNullable(user.getLogin()).ifPresent(predicate -> predicateList.add(builder.equal(root.get("login"), user.getLogin())));
        Optional.ofNullable(user.getPassword()).ifPresent(predicate -> predicateList.add(builder.equal(root.get("password"), user.getPassword())));
        Optional.ofNullable(user.getFirstname()).ifPresent(predicate -> predicateList.add(builder.equal(root.get("firstname"), user.getFirstname())));
        Optional.ofNullable(user.getLastname()).ifPresent(predicate -> predicateList.add(builder.equal(root.get("lastname"), user.getLastname())));
        Optional.ofNullable(user.getEmail()).ifPresent(predicate -> predicateList.add(builder.equal(root.get("email"), user.getEmail())));
        criteriaQuery.select(root).where(predicateList.toArray(new Predicate[0]));
        return session.createQuery(criteriaQuery).getResultList();
    }

    /**
     * Method that removes {@link User} from database by id.
     *
     * @param id {@link Integer}
     * @return {@link Boolean}
     */
    @Override
    public Boolean removeById(Long id) {
        openCurrentSessionWithTransaction();
        currentSession.remove(currentSession.get(User.class, id));
        closeCurrentSessionWithTransaction();
        return true;
    }
}
