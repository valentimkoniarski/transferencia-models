package dev.valentim.usuario.config;

import dev.valentim.usuario.Usuario;
import dev.valentim.usuario.UsuarioRepository;
import dev.valentim.usuario.UsuarioService;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackageClasses = {UsuarioService.class})
@EntityScan(basePackageClasses = {Usuario.class})
@EnableJpaRepositories(basePackageClasses = {UsuarioRepository.class})
public class AppConfig {
}

