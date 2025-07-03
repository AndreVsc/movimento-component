package io.github.andrevsc.movimento_component;

import io.github.andrevsc.movimento_component.component.MovimentoComponent;
import io.github.andrevsc.movimento_component.model.Movimento;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class MovimentoComponentTest {
    
    @Autowired
    private MovimentoComponent component;
    
    @Test
    public void testAdicionarMovimento() {
        Movimento movimento = component.adicionarMovimento("Chama", "Fire", "Special", 90, 100, 15);
        assertNotNull(movimento);
        assertEquals("Chama", movimento.getNome());
        assertEquals("Fire", movimento.getTipo());
    }
    
    @Test
    public void testBuscarMovimento() {
        Movimento movimento = component.adicionarMovimento("Surf", "Water", "Special", 90, 100, 15);
        Optional<Movimento> found = component.buscarMovimento(movimento.getIdMovimento());
        assertTrue(found.isPresent());
        assertEquals("Surf", found.get().getNome());
    }
    
    @Test
    public void testListarMovimentos() {
        component.adicionarMovimento("Tackle", "Normal", "Physical", 40, 100, 35);
        component.adicionarMovimento("Thunder", "Electric", "Special", 110, 70, 10);
        assertTrue(component.listarMovimentos().size() >= 2);
    }
    
    @Test
    public void testRemoverMovimento() {
        Movimento movimento = component.adicionarMovimento("Scratch", "Normal", "Physical", 40, 100, 35);
        assertTrue(component.removerMovimento(movimento.getIdMovimento()));
        assertFalse(component.buscarMovimento(movimento.getIdMovimento()).isPresent());
    }
    
    @Test
    public void testValidacaoNomeVazio() {
        assertThrows(IllegalArgumentException.class, () -> {
            component.adicionarMovimento("", "Fire", "Special", 90, 100, 15);
        });
    }
}