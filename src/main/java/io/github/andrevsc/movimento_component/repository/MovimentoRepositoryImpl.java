package io.github.andrevsc.movimento_component.repository;

import io.github.andrevsc.movimento_component.internal.IMovimentoRepository;
import io.github.andrevsc.movimento_component.required.IPersistenceProvider;
import io.github.andrevsc.movimento_component.model.Movimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public class MovimentoRepositoryImpl implements IMovimentoRepository {
    
    private final IPersistenceProvider<Movimento, Long> persistenceProvider;
    
    @Autowired
    public MovimentoRepositoryImpl(IPersistenceProvider<Movimento, Long> persistenceProvider) {
        this.persistenceProvider = persistenceProvider;
    }
    
    @Override
    public Movimento save(Movimento movimento) {
        return persistenceProvider.save(movimento);
    }
    
    @Override
    public Optional<Movimento> findById(Long id) {
        return persistenceProvider.findById(id);
    }
    
    @Override
    public List<Movimento> findAll() {
        return persistenceProvider.findAll();
    }
    
    @Override
    public boolean existsById(Long id) {
        return persistenceProvider.existsById(id);
    }
    
    @Override
    public void deleteById(Long id) {
        persistenceProvider.deleteById(id);
    }
    
    @Override
    public Optional<Movimento> findByNome(String nome) {
        return persistenceProvider.findByField("nome", nome);
    }
    
    @Override
    public List<Movimento> findByTipo(String tipo) {
        // Implementação específica seria delegada ao provider
        return persistenceProvider.findAll().stream()
                .filter(m -> m.getTipo().equalsIgnoreCase(tipo))
                .toList();
    }
    
    @Override
    public List<Movimento> findByCategoria(String categoria) {
        return persistenceProvider.findAll().stream()
                .filter(m -> m.getCategoria().equalsIgnoreCase(categoria))
                .toList();
    }
    
    @Override
    public List<Movimento> findByPoderBetween(Integer min, Integer max) {
        return persistenceProvider.findAll().stream()
                .filter(m -> m.getPoder() != null && m.getPoder() >= min && m.getPoder() <= max)
                .toList();
    }

    @Override
    public boolean existsByNome(String nome) {
        throw new UnsupportedOperationException("Unimplemented method 'existsByNome'");
    }
}