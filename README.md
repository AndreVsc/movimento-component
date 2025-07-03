# Movimento Component

## Visão Geral

O **Movimento Component** é um componente Java desenvolvido para gerenciar entidades do tipo "Movimento" (inspirado em sistemas de batalha de jogos, como Pokémon), permitindo operações de criação, busca, listagem e remoção de movimentos. O projeto foi construído seguindo boas práticas de engenharia de software, com foco em modularidade, testabilidade e reutilização.

## Critérios Atendidos

### 1. Utilização do Padrão de Interface de Componente
O projeto adota o **Padrão de Interface de Componente**. As interfaces `IMovimentoComponent`, `IPersistenceProvider` e `IValidationProvider` definem contratos claros para os serviços do componente, promovendo baixo acoplamento e alta coesão. Implementações concretas são injetadas via Spring, facilitando substituição e testes.

### 2. Aplicação dos Princípios SOLID
Pelo menos três princípios SOLID foram aplicados:
- **S (Single Responsibility Principle):** Cada classe tem uma responsabilidade única, como validação (`DefaultValidationProvider`), persistência (`JpaPersistenceProvider`) e lógica de negócio (`MovimentoComponent`).
- **O (Open/Closed Principle):** As interfaces permitem que novas implementações sejam adicionadas sem modificar o código existente.
- **D (Dependency Inversion Principle):** O componente depende de abstrações (interfaces), não de implementações concretas, facilitando testes e extensibilidade.

### 3. Ferramenta de Build e Gerenciamento de Dependências
O projeto utiliza o **Maven** (`pom.xml`) para build, gerenciamento de dependências e empacotamento, garantindo reprodutibilidade e integração com o ecossistema Java.

### 4. Publicação em Serviço de Hospedagem de Módulos
O componente foi publicado no **Maven Central Repository**, permitindo que outros projetos o utilizem como dependência. O diretório `central-publishing/` e arquivos `.pom` e `.jar` em `target/` evidenciam o processo de deploy.

### 5. Versionamento Semântico
O projeto segue **versionamento semântico** (exemplo: `1.0.4`), facilitando a evolução controlada do componente e a compatibilidade entre versões.

### 6. Testes do Componente
O componente é testado por meio de **testes unitários** (diretório `src/test/java/`) e pode ser integrado a outros projetos como dependência, validando seu funcionamento em cenários reais.

## Como Usar

1. **Adicione a dependência no seu `pom.xml`:**
```xml
<dependency>
    <groupId>io.github.andrevsc</groupId>
    <artifactId>movimento-component</artifactId>
    <version>1.0.4</version>
</dependency>
```

2. **Configure o Spring para escanear os pacotes do componente:**
O arquivo `MovimentoComponentConfig.java` já provê a configuração necessária.

3. **Utilize a interface `IMovimentoComponent` em seu serviço:**
```java
@Autowired
private IMovimentoComponent movimentoComponent;
```

## Estrutura do Projeto
- `component/` - Implementação principal do componente
- `model/` - Entidade JPA `Movimento`
- `provider/` - Provedores de persistência e validação
- `internal/` - Contratos internos para repositórios e serviços
- `test/` - Testes unitários

## Licença
Consulte o arquivo `LICENSE` para detalhes.

---

Este projeto demonstra a aplicação de padrões de projeto, princípios SOLID e práticas modernas de desenvolvimento de componentes Java, pronto para uso e extensão em sistemas maiores.
