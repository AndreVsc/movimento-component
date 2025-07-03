package io.github.andrevsc.movimento_component.service;

import io.github.andrevsc.movimento_component.model.Movimento;
import io.github.andrevsc.movimento_component.repository.MovimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MovimentoService {
    private final MovimentoRepository repository;
    
    @Autowired
    public MovimentoService(MovimentoRepository repository) {
        this.repository = repository;
    }
    
    public Movimento createMovimento(String nome, String tipo, String categoria, Integer poder, Integer precisao, Integer ppMax) {
        validateMovimento(nome, tipo, categoria, precisao, ppMax);
        
        if (repository.existsByNome(nome)) {
            throw new IllegalArgumentException("Movimento com este nome já existe");
        }
        
        Movimento movimento = new Movimento(nome, tipo, categoria, poder, precisao, ppMax);
        return repository.save(movimento);
    }
    
    public Optional<Movimento> getMovimento(Long id) {
        return repository.findById(id);
    }
    
    public List<Movimento> getAllMovimentos() {
        return repository.findAll();
    }
    
    public boolean deleteMovimento(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
    
    private void validateMovimento(String nome, String tipo, String categoria, Integer precisao, Integer ppMax) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new IllegalArgumentException("Tipo não pode ser vazio");
        }
        if (categoria == null || categoria.trim().isEmpty()) {
            throw new IllegalArgumentException("Categoria não pode ser vazia");
        }
        if (precisao == null || precisao < 0 || precisao > 100) {
            throw new IllegalArgumentException("Precisão deve estar entre 0 e 100");
        }
        if (ppMax == null || ppMax <= 0) {
            throw new IllegalArgumentException("PP Max deve ser maior que 0");
        }
    }
}