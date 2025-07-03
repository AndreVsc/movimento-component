# Como Usar o Movimento Component

Este guia mostra como adicionar e utilizar o **Movimento Component** em um projeto Spring Boot.

---

## 1. Adicione a dependência no seu `pom.xml`

```xml
<dependency>
    <groupId>io.github.andrevsc</groupId>
    <artifactId>movimento-component</artifactId>
    <version>1.0.4</version>
</dependency>
```

---

## 2. Configure o Spring Boot

O componente já traz uma configuração automática. Se necessário, adicione:

```java
// Não é obrigatório, mas se quiser garantir o scan:
import io.github.andrevsc.movimento_component.config.MovimentoComponentConfig;
import org.springframework.context.annotation.Import;

@Import(MovimentoComponentConfig.class)
@SpringBootApplication
public class SeuProjetoApplication { }
```

---

## 3. Injete e use o componente

No seu serviço, injete a interface `IMovimentoComponent`:

```java
import io.github.andrevsc.movimento_component.provided.IMovimentoComponent;
import io.github.andrevsc.movimento_component.model.Movimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimentoService {
    private final IMovimentoComponent movimentoComponent;

    @Autowired
    public MovimentoService(IMovimentoComponent movimentoComponent) {
        this.movimentoComponent = movimentoComponent;
    }

    public Movimento criarMovimento(String nome, String tipo, String categoria, Integer poder, Integer precisao, Integer ppMax) {
        return movimentoComponent.criarMovimento(nome, tipo, categoria, poder, precisao, ppMax);
    }

    public List<Movimento> listarMovimentos() {
        return movimentoComponent.listarMovimentos();
    }
}
```

---

## 4. Exemplo de uso em Controller

```java
import io.github.andrevsc.movimento_component.model.Movimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/movimentos")
public class MovimentoController {
    @Autowired
    private MovimentoService movimentoService;

    @PostMapping
    public Movimento criar(@RequestBody Movimento movimento) {
        return movimentoService.criarMovimento(
            movimento.getNome(),
            movimento.getTipo(),
            movimento.getCategoria(),
            movimento.getPoder(),
            movimento.getPrecisao(),
            movimento.getPpMax()
        );
    }

    @GetMapping
    public List<Movimento> listar() {
        return movimentoService.listarMovimentos();
    }
}
```

---

## 5. Pronto!

Agora seu projeto já pode criar, listar e gerenciar movimentos usando o componente pronto, com validação e persistência automática.

---

**Dica:** Consulte o README para mais detalhes sobre arquitetura, testes e versionamento.
