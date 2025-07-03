package io.github.andrevsc.movimento_component.provider;

import io.github.andrevsc.movimento_component.required.IPersistenceProvider;
import io.github.andrevsc.movimento_component.model.Movimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaPersistenceProvider extends JpaRepository<Movimento, Long>, IPersistenceProvider<Movimento, Long> {
    
    Optional<Movimento> findByNome(String nome);
    List<Movimento> findByTipo(String tipo);
    
    @Override
    default Optional<Movimento> findByField(String fieldName, Object value) {
        if ("nome".equals(fieldName)) {
            return findByNome((String) value);
        }
        return Optional.empty();
    }
    
    @Override
    default List<Movimento> findByFieldValue(String fieldName, Object value) {
        if ("tipo".equals(fieldName)) {
            return findByTipo((String) value);
        }
        return List.of();
    }
}