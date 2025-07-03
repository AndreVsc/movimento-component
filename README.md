# Movimento Component

## ✨ O que é este componente?

O **Movimento Component** é um componente Java pronto para uso, projetado para facilitar o gerenciamento de entidades do tipo **Movimento** — comuns em sistemas de batalha de jogos (como Pokémon). Ele oferece operações completas de **criação, busca, listagem e remoção** de movimentos, com validação automática e persistência integrada via JPA/Spring Data.

O objetivo é permitir que você adicione funcionalidades robustas de "movimentos" ao seu sistema, sem se preocupar com detalhes de implementação, validação ou persistência. Basta importar, configurar e usar!

---

## 🚀 Principais Funcionalidades
- **CRUD completo** para entidades Movimento
- **Validação automática** dos dados (campos obrigatórios, faixas válidas, etc.)
- **Persistência desacoplada** (pode ser adaptada para diferentes bancos)
- **Pronto para uso com Spring Boot**
- **Fácil integração** em qualquer projeto Java
- **Testes unitários incluídos**
- **Versionamento semântico**
- **Publicação no Maven Central**

---


## 🏗️ Arquitetura e Padrões Utilizados

### 1. Padrão de Interface de Componente
O projeto adota o **Padrão de Interface de Componente**. As interfaces `IMovimentoComponent`, `IPersistenceProvider` e `IValidationProvider` definem contratos claros para os serviços do componente, promovendo baixo acoplamento e alta coesão. Implementações concretas são injetadas via Spring, facilitando substituição e testes.

### 2. Princípios SOLID Aplicados
Pelo menos três princípios SOLID foram aplicados:
- **S (Single Responsibility Principle):** Cada classe tem uma responsabilidade única, como validação (`DefaultValidationProvider`), persistência (`JpaPersistenceProvider`) e lógica de negócio (`MovimentoComponent`).
- **O (Open/Closed Principle):** As interfaces permitem que novas implementações sejam adicionadas sem modificar o código existente.
- **D (Dependency Inversion Principle):** O componente depende de abstrações (interfaces), não de implementações concretas, facilitando testes e extensibilidade.

### 3. Build e Gerenciamento de Dependências
O projeto utiliza o **Maven** (`pom.xml`) para build, gerenciamento de dependências e empacotamento, garantindo reprodutibilidade e integração com o ecossistema Java.

### 4. Publicação e Distribuição
O componente foi **publicado no Maven Central Repository**, permitindo que outros projetos o utilizem como dependência. O diretório `central-publishing/` e arquivos `.pom` e `.jar` em `target/` evidenciam o processo de deploy. Isso garante fácil acesso e integração em qualquer projeto Java.

### 5. Versionamento Semântico
O projeto segue **versionamento semântico** (exemplo: `1.0.4`), facilitando a evolução controlada do componente e a compatibilidade entre versões.

### 6. Testes Automatizados
O componente é testado por meio de **testes unitários** (diretório `src/test/java/`) e pode ser integrado a outros projetos como dependência, validando seu funcionamento em cenários reais.


## 🛠️ Como Usar

1. **Adicione a dependência no seu `pom.xml`:**
```xml
<dependency>
    <groupId>io.github.andrevsc</groupId>
    <artifactId>movimento-component</artifactId>
    <version>1.0.4</version>
</dependency>
```

2. **Configure o Spring para escanear os pacotes do componente:**
O arquivo `MovimentoComponentConfig.java` já provê a configuração necessária. Em projetos Spring Boot, normalmente não é preciso nenhuma configuração extra.

3. **Utilize a interface `IMovimentoComponent` em seu serviço:**
```java
@Autowired
private IMovimentoComponent movimentoComponent;
```

4. **Exemplo de uso:**
```java
Movimento novo = movimentoComponent.criarMovimento(
    "Trovão",
    "Elétrico",
    "Especial",
    90,
    100,
    15
);

List<Movimento> todos = movimentoComponent.listarMovimentos();
```

## 📁 Estrutura do Projeto
- `component/` — Implementação principal do componente
- `model/` — Entidade JPA `Movimento`
- `provider/` — Provedores de persistência e validação
- `internal/` — Contratos internos para repositórios e serviços
- `test/` — Testes unitários

## 📦 Licença
Consulte o arquivo `LICENSE` para detalhes.

---

> Este projeto demonstra a aplicação de padrões de projeto, princípios SOLID e práticas modernas de desenvolvimento de componentes Java, pronto para uso e extensão em sistemas maiores.
