package com.airafrika.Libs;

import com.airafrika.Core.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Dao<T> implements DaoInterface<T> {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private final EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();

    @Override
    public Optional<T> get(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    @Transactional
    public Optional<T> create(T entity) {
//        try (Session session = sessionFactory.openSession()) {
            EntityTransaction transaction = em.getTransaction();
            try {
                transaction.begin();
                em.persist(entity);
                transaction.commit();
                return Optional.of(entity);
            } catch (Exception e) {
                System.err.println(e.getMessage());
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                return Optional.empty();
            }
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//            return Optional.empty();
//        }
    }

    @Override
    public Optional<T> update(T entity) {
        return Optional.empty();
    }

    @Override
    public List<T> find(Object criteria) {
        return null;
    }

    @Override
    public boolean delete(T entity) {
        return false;
    }
}
