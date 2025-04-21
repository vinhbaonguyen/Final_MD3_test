package ra.md3finaltest.service;

import java.util.List;

public interface IGenericService <T,E>{
    List<T> findAll();
    T findById(E id);
    void create(T entity);
    void update(T entity, E id);
    void delete(E id);
}
