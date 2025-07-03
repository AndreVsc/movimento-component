package io.github.andrevsc.movimento_component.component;

import io.github.andrevsc.movimento_component.model.Movimento;
import io.github.andrevsc.movimento_component.service.MovimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class MovimentoComponent {
    private final MovimentoService service;
    
    @Autowired
    public MovimentoComponent(MovimentoService service) {
        this.service = service;
    }
    
    public Movimento adicionarMovimento(String nome, String tipo, String categoria, Integer poder, Integer precisao, Integer ppMax) {
        return service.createMovimento(nome, tipo, categoria, poder, precisao, ppMax);
    }
    
    public Optional<Movimento> buscarMovimento(Long id) {
        return service.getMovimento(id);
    }
    
    public List<Movimento> listarMovimentos() {
        return service.getAllMovimentos();
    }
    
    public boolean removerMovimento(Long id) {
        return service.deleteMovimento(id);
    }
}