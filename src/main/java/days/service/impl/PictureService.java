package days.service.impl;

import days.model.Picture;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class PictureService implements IPictureService{
    private static SessionFactory sessionFactory;
    private  static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        }catch (HibernateException e){
            e.getStackTrace();
        }
    }

    @Override
    public List<Picture> findAll() {
        String queryStr ="SELECT p FROM Picture AS p";
        TypedQuery<Picture> query = entityManager.createQuery(queryStr,Picture.class);
        return query.getResultList();
    }

    @Override
    public Picture findOne(Long id) {
        String queryStr = "SELECT p FROM Picture AS p WHERE p.id = :id";
        TypedQuery<Picture> query = entityManager.createQuery(queryStr,Picture.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public Picture save(Picture model) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Picture origin = new Picture();

            origin.setScore(model.getScore());
            origin.setAuthor(model.getAuthor());
            origin.setFeedback(model.getFeedback());
            origin.setLikes(model.getLikes());
            session.save(origin);
            transaction.commit();
            return origin;
        }catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public Picture update(Picture picture) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Picture origin = findOne(picture.getId());

            origin.setScore(picture.getScore());
            origin.setAuthor(picture.getAuthor());
            origin.setFeedback(picture.getFeedback());
            origin.setLikes(picture.getLikes());
            session.save(origin);
            transaction.commit();
            return origin;
        }catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public List<Picture> save(List<Picture> models) {
        return null;
    }

    @Override
    public boolean exists(Long id) {
        return false;
    }

    @Override
    public List<Picture> findAll(List<Long> ids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(Picture model) {

    }

    @Override
    public void delete(List<Picture> models) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Picture updateLike(Long id) {
        String queryStr = "UPDATE Picture SET Picture.likes=(likes+1) WHERE Picture .id = :id";
        TypedQuery<Picture> query = entityManager.createQuery(queryStr,Picture.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }
}
