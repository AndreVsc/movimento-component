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
    public void testCriarMovimento() {
        Movimento movimento = component.criarMovimento("Chama", "Fire", "Special", 90, 100, 15);
        assertNotNull(movimento);
        assertEquals("Chama", movimento.getNome());
        assertEquals("Fire", movimento.getTipo());
    }

    @Test
    public void testBuscarMovimento() {
        Movimento movimento = component.criarMovimento("Surf", "Water", "Special", 90, 100, 15);
        Optional<Movimento> found = component.buscarMovimento(movimento.getId());
        assertTrue(found.isPresent());
        assertEquals("Surf", found.get().getNome());
    }

    @Test
    public void testListarMovimentos() {
        component.criarMovimento("Tackle", "Normal", "Physical", 40, 100, 35);
        component.criarMovimento("Thunder", "Electric", "Special", 110, 70, 10);
        assertTrue(component.listarMovimentos().size() >= 2);
    }

    @Test
    public void testRemoverMovimento() {
        Movimento movimento = component.criarMovimento("Scratch", "Normal", "Physical", 40, 100, 35);
        assertTrue(component.removerMovimento(movimento.getId()));
        assertFalse(component.buscarMovimento(movimento.getId()).isPresent());
    }

    @Test
    public void testValidacaoNomeVazio() {
        assertThrows(IllegalArgumentException.class, () -> {
            component.criarMovimento("", "Fire", "Special", 90, 100, 15);
        });
    }

    @Test
    public void testBuscarPorNome() {
        component.criarMovimento("Ice Beam", "Ice", "Special", 90, 100, 10);
        Optional<Movimento> found = component.buscarPorNome("Ice Beam");
        assertTrue(found.isPresent());
        assertEquals("Ice", found.get().getTipo());
    }

    @Test
    public void testBuscarPorTipo() {
        component.criarMovimento("Quick Attack", "Normal", "Physical", 40, 100, 30);
        component.criarMovimento("Body Slam", "Normal", "Physical", 85, 100, 15);
        var normais = component.buscarPorTipo("Normal");
        assertTrue(normais.size() >= 2);
        assertTrue(normais.stream().allMatch(m -> m.getTipo().equals("Normal")));
    }
}