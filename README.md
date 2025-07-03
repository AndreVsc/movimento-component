# movimento-component

Componente Spring Boot para gerenciamento de movimentos de Pokémon.

## Visão Geral
Este projeto implementa um componente reutilizável para cadastro, consulta, listagem e remoção de movimentos de Pokémon, seguindo o Padrão de Interface de Componente. O componente é facilmente integrável a outros projetos Spring Boot.

## Critérios Atendidos

### 1. Padrão de Interface de Componente
O projeto define uma interface clara de uso via a classe `MovimentoComponent`, que expõe métodos para manipulação dos movimentos, desacoplando a lógica interna do componente do consumidor.

### 2. Princípios SOLID Aplicados
- **S (Single Responsibility Principle):** Cada classe possui uma única responsabilidade. Por exemplo, `MovimentoService` gerencia regras de negócio, `MovimentoRepository` lida com persistência, e `MovimentoComponent` expõe a interface do componente.
- **O (Open/Closed Principle):** As classes são abertas para extensão e fechadas para modificação. Novas regras podem ser adicionadas ao serviço sem alterar a interface do componente.
- **D (Dependency Injection/Dependency Inversion Principle):** O projeto utiliza injeção de dependências do Spring para desacoplar as classes, facilitando testes e manutenção.

### 3. Ferramenta de Build e Gerenciamento de Dependências
O projeto utiliza **Maven** para build, gerenciamento de dependências e plugins de publicação.

### 4. Publicação em Serviço de Hospedagem de Módulos
O componente está configurado para publicação no **Maven Central Repository** via o plugin `central-publishing-maven-plugin`.

### 5. Versionamento Semântico
O projeto segue versionamento semântico, conforme especificado no `pom.xml` (exemplo: `1.0.3`).

### 6. Testes
- **Testes Unitários:** O projeto inclui testes unitários utilizando o Spring Boot Starter Test.
- **Integração:** O componente pode ser importado como dependência em outros projetos para testes de integração.

## Como Usar

1. **Adicionar Dependência**
   ```xml
   <dependency>
     <groupId>io.github.andrevsc</groupId>
     <artifactId>movimento-component</artifactId>
     <version>1.0.3</version>
   </dependency>
   ```

2. **Injetar o Componente**
   ```java
   @Autowired
   private MovimentoComponent movimentoComponent;
   ```

3. **Exemplo de Uso**
   ```java
   movimentoComponent.adicionarMovimento("Tackle", "Normal", "Físico", 40, 100, 35);
   List<Movimento> movimentos = movimentoComponent.listarMovimentos();
   ```

## Build e Testes

Para compilar e rodar os testes:
```shell
./mvnw clean install
```

## Publicação
Para publicar no Maven Central, utilize:
```shell
./mvnw deploy
```

## Licença
MIT License

## Autor
[andrevsc](mailto:vsandre40@gmail.com)

---
Este projeto atende aos critérios de projeto de componentes, SOLID, build, publicação, versionamento e testes conforme solicitado.
