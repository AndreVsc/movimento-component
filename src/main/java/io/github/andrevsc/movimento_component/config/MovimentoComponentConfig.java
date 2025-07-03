package io.github.andrevsc.movimento_component.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("io.github.andrevsc.movimento_component")
@EnableJpaRepositories("io.github.andrevsc.movimento_component.provider")
@EntityScan("io.github.andrevsc.movimento_component.model")
public class MovimentoComponentConfig {
}
