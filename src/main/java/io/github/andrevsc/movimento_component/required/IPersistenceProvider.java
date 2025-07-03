package io.github.andrevsc.movimento_component.required;

import java.util.List;
import java.util.Optional;

public interface IPersistenceProvider<T, ID> {
    T save(T entity);
    Optional<T> findById(ID id);
    List<T> findAll();
    boolean existsById(ID id);
    void deleteById(ID id);
    Optional<T> findByField(String fieldName, Object value);
    List<T> findByFieldValue(String fieldName, Object value);
}