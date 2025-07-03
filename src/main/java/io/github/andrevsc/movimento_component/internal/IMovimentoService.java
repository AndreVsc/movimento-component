package io.github.andrevsc.movimento_component.internal;

import io.github.andrevsc.movimento_component.model.Movimento;
import java.util.List;
import java.util.Optional;

public interface IMovimentoService {
    Movimento createMovimento(String nome, String tipo, String categoria, Integer poder, Integer precisao, Integer ppMax);
    Optional<Movimento> getMovimento(Long id);
    List<Movimento> getAllMovimentos();
    boolean deleteMovimento(Long id);
    Optional<Movimento> getMovimentoByNome(String nome);
    List<Movimento> getMovimentosByTipo(String tipo);
    List<Movimento> getMovimentosByCategoria(String categoria);
    List<Movimento> getMovimentosByPoderRange(Integer min, Integer max);
}
