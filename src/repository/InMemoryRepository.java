package repository;

import domain.Entity;

import java.util.List;

public class InMemoryRepository<T extends Entity> implements repository.IRepository<T> {
    @Override
    public void create(T entity) throws repository.RepositoryException {

    }

    @Override
    public T readOne(int id) {
        return null;
    }

    @Override
    public List<T> read() {
        return null;
    }

    @Override
    public void update(T entity) throws repository.RepositoryException {

    }

    @Override
    public void delete(int id) throws repository.RepositoryException {

    }
}
