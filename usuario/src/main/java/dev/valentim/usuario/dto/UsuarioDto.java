package dev.valentim.usuario.dto;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@Getter
@Setter
public class UsuarioDto {
    @NotNull
    private Long id;
    @NotNull
    private String nome;
    @NotNull
    private String inscricao;
    @NotNull
    private String email;
    @NotNull
    private String senha;
    @NotNull
    private UUID chave = UUID.randomUUID();
}
