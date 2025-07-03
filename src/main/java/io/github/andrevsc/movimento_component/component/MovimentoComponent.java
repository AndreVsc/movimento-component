package io.github.andrevsc.movimento_component.component;

import io.github.andrevsc.movimento_component.provided.IMovimentoComponent;
import io.github.andrevsc.movimento_component.required.IPersistenceProvider;
import io.github.andrevsc.movimento_component.required.IValidationProvider;
import io.github.andrevsc.movimento_component.model.Movimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MovimentoComponent implements IMovimentoComponent {
    
    private final IPersistenceProvider<Movimento, Long> persistenceProvider;
    private final IValidationProvider validationProvider;
    
    @Autowired
    public MovimentoComponent(IPersistenceProvider<Movimento, Long> persistenceProvider,
                             IValidationProvider validationProvider) {
        this.persistenceProvider = persistenceProvider;
        this.validationProvider = validationProvider;
    }
    
    @Override
    public Movimento criarMovimento(String nome, String tipo, String categoria, Integer poder, Integer precisao, Integer ppMax) {
        // Validações
        validationProvider.validateRequired("Nome", nome);
        validationProvider.validateRequired("Tipo", tipo);
        validationProvider.validateRequired("Categoria", categoria);
        validationProvider.validateRange("Precisão", precisao, 0, 100);
        validationProvider.validatePositive("PP Max", ppMax);
        
        // Verificar se já existe
        Optional<Movimento> existente = persistenceProvider.findByField("nome", nome);
        if (existente.isPresent()) {
            throw new IllegalArgumentException("Movimento com nome '" + nome + "' já existe");
        }
        
        // Criar e salvar
        Movimento movimento = new Movimento(nome, tipo, categoria, poder, precisao, ppMax);
        return persistenceProvider.save(movimento);
    }
    
    @Override
    public Optional<Movimento> buscarMovimento(Long id) {
        return persistenceProvider.findById(id);
    }
    
    @Override
    public List<Movimento> listarMovimentos() {
        return persistenceProvider.findAll();
    }
    
    @Override
    public boolean removerMovimento(Long id) {
        if (persistenceProvider.existsById(id)) {
            persistenceProvider.deleteById(id);
            return true;
        }
        return false;
    }
    
    @Override
    public Optional<Movimento> buscarPorNome(String nome) {
        return persistenceProvider.findByField("nome", nome);
    }
    
    @Override
    public List<Movimento> buscarPorTipo(String tipo) {
        return persistenceProvider.findByFieldValue("tipo", tipo);
    }
}