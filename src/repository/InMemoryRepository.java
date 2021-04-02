package repository;

import domain.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository<T extends Entity> implements repository.IRepository<T> {
    private final Map<Integer, T> storage = new HashMap<>();

    /**
     * @param entity the entity to add
     * @throws repository.RepositoryException if the id already exists
     */
    @Override
    public void create(T entity) throws repository.RepositoryException {
        if (this.storage.containsKey(entity.getIdEntity())) {
            throw new RepositoryException("The id already exists!");
        }

        this.storage.put(entity.getIdEntity(), entity);
    }

    /**
     * @param id the id
     * @return the entity with the given id, or null if none exists
     */
    @Override
    public T readOne(int id) {
        return this.storage.get(id);
    }

    /**
     * @return all entity.
     */
    @Override
    public List<T> read() {
        return new ArrayList<>(this.storage.values());
    }

    /**
     * @param entity the given entity.
     * @throws repository.RepositoryException if the entity id does not exist.
     */
    @Override
    public void update(T entity) throws repository.RepositoryException {
        if (!this.storage.containsKey(entity.getIdEntity())) {
            throw new RepositoryException("There is no cookie with the given id to update!");
        }

        this.storage.put(entity.getIdEntity(), entity);
    }

    /**
     * Deletes an entity with a given id.
     *
     * @param id the id of the entity to delete.
     * @throws repository.RepositoryException if there is no entity with the given id.
     */
    @Override
    public void delete(int id) throws repository.RepositoryException {
        if (!this.storage.containsKey(id)) {
            throw new RepositoryException("There is no entity with the given id to delete!");
        }

        this.storage.remove(id);
    }
}

