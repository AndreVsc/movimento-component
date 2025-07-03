package io.github.andrevsc.movimento_component.provided;

import io.github.andrevsc.movimento_component.model.Movimento;
import java.util.List;
import java.util.Optional;

public interface IMovimentoComponent {
    Movimento criarMovimento(String nome, String tipo, String categoria, Integer poder, Integer precisao, Integer ppMax);
    Optional<Movimento> buscarMovimento(Long id);
    List<Movimento> listarMovimentos();
    boolean removerMovimento(Long id);
    Optional<Movimento> buscarPorNome(String nome);
    List<Movimento> buscarPorTipo(String tipo);
}