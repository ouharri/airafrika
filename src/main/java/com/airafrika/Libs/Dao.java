package com.airafrika.Libs;

import com.airafrika.Core.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Generic Data Access Object (DAO) for database operations.
 *
 * @param <T> The entity type this DAO operates on.
 */
public class Dao<T> implements DaoInterface<T> {

    private final Class<T> _class;

    protected final EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();

    @SuppressWarnings("unchecked")
    public Dao() {
        ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
        Type type = superClass.getActualTypeArguments()[0];
        _class = (Class<T>) type;
    }

    /**
     * Retrieve an entity by its ID.
     *
     * @param id The ID of the entity to retrieve.
     * @return An Optional containing the entity if found, or empty if not found.
     */
    @Override
    public Optional<T> get(UUID id) {
        return Optional.ofNullable(entityManager.find(_class, id));
    }

    /**
     * Retrieve all entities of type T from the database.
     *
     * @return A list of entities of type T.
     */
    @Override
    public List<T> getAll() {
        TypedQuery<T> query = entityManager.createQuery("FROM " + _class.getName(), _class);
        return query.getResultList();
    }

    /**
     * Create a new entity in the database.
     *
     * @param entity The entity to create.
     * @return An Optional containing the created entity, or empty if creation failed.
     */
    @Override
    @Transactional
    public Optional<T> create(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
            return Optional.of(entity);
        } catch (Exception e) {
            System.err.println("Error while creating entity: " + e.getMessage());
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return Optional.empty();
        }
    }

    /**
     * Update an entity in the database.
     *
     * @param entity The entity to update.
     * @return An Optional containing the updated entity, or empty if the update failed.
     */
    @Override
    @Transactional
    public Optional<T> update(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            T updatedEntity = entityManager.merge(entity);
            transaction.commit();
            return Optional.of(updatedEntity);
        } catch (Exception e) {
            System.err.println("Error while updating entity: " + e.getMessage());
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return Optional.empty();
        }
    }

    /**
     * Find an entity based on custom criteria.
     *
     * @param criteria The criteria for the search.
     * @return An Optional containing the found entity, or empty if not found.
     */
    @Override
    public Optional<T> find(Object criteria) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            T entity = entityManager.find(_class, criteria);
            transaction.commit();
            return Optional.ofNullable(entity);
        } catch (Exception e) {
            System.err.println("Error while finding entity: " + e.getMessage());
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return Optional.empty();
        }
    }

    /**
     * Delete an entity from the database.
     *
     * @param entity The entity to delete.
     * @return true if deletion is successful, false otherwise.
     */
    @Override
    @Transactional
    public boolean delete(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.err.println("Error while deleting entity: " + e.getMessage());
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return false;
        }
    }
}