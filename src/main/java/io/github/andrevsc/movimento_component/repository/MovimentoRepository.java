package io.github.andrevsc.movimento_component.repository;

import io.github.andrevsc.movimento_component.model.Movimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MovimentoRepository extends JpaRepository<Movimento, Long> {
    Optional<Movimento> findByNome(String nome);
    boolean existsByNome(String nome);
}