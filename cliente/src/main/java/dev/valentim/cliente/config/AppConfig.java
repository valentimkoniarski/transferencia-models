package dev.valentim.cliente.config;

import dev.valentim.cliente.Cliente;
import dev.valentim.cliente.ClienteService;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackageClasses = {ClienteService.class})
@EntityScan(basePackageClasses = {Cliente.class})
@EnableJpaRepositories(basePackageClasses = {ClienteService.class})
public class AppConfig {
}

