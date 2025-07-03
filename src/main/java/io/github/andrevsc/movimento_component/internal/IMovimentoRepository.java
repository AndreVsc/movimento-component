package io.github.andrevsc.movimento_component.internal;

import io.github.andrevsc.movimento_component.model.Movimento;
import java.util.List;
import java.util.Optional;

public interface IMovimentoRepository {
    Movimento save(Movimento movimento);
    Optional<Movimento> findById(Long id);
    List<Movimento> findAll();
    boolean existsById(Long id);
    void deleteById(Long id);
    boolean existsByNome(String nome);
    Optional<Movimento> findByNome(String nome);
    List<Movimento> findByTipo(String tipo);
    List<Movimento> findByCategoria(String categoria);
    List<Movimento> findByPoderBetween(Integer min, Integer max);
}