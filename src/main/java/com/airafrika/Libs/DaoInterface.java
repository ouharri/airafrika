package com.airafrika.Libs;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * An interface for Data Access Objects (DAOs) that perform CRUD operations on entities of type T.
 *
 * @param <T> The type of entity to be managed.
 */
public interface DaoInterface<T> {

    /**
     * Retrieves an entity by its unique identifier.
     *
     * @param id The unique identifier of the entity.
     * @return An Optional containing the retrieved entity, or an empty Optional if not found.
     * @throws SQLException If a database access error occurs.
     */
    Optional<T> get(UUID id);

    /**
     * Retrieves all entities of type T.
     *
     * @return A list of all entities.
     */
    List<T> getAll();

    /**
     * Creates a new entity in the database.
     *
     * @param entity The entity to be created.
     * @return An Optional containing the created entity, or an empty Optional if there's an error.
     * @throws SQLException If a database access error occurs.
     */
    Optional<T> create(T entity) throws SQLException;

    /**
     * Updates an existing entity in the database.
     *
     * @param entity The entity to be updated.
     * @return An Optional containing the updated entity, or an empty Optional if there's an error.
     */
    Optional<T> update(T entity);

    /**
     * Finds entities based on certain search criteria.
     *
     * @param criteria The search criteria.
     * @return A list of entities that match the criteria.
     */
    List<T> find(Object criteria);

    /**
     * Deletes an entity from the database.
     *
     * @param entity The entity to be deleted.
     * @return True if the deletion is successful, otherwise false.
     */
    boolean delete(T entity);
}
