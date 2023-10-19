package dev.valentim.usuario.dto;

import dev.valentim.usuario.Usuario;
import org.springframework.security.core.context.SecurityContextHolder;

public class UsuarioConfigDto implements UsuarioImpl {
    private UsuarioDto usuarioDto;

    public void configurarUsuario() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Usuario usuario;


        if (principal instanceof Usuario) {
            usuario = (Usuario) principal;

            UsuarioDto usuarioDto = new UsuarioDto();
            usuarioDto.setId(usuario.getId());
            usuarioDto.setNome(usuario.getNome());
            usuarioDto.setInscricao(usuario.getInscricao());
            usuarioDto.setEmail(usuario.getEmail());
            usuarioDto.setSenha(usuario.getSenha());

            this.usuarioDto = usuarioDto;
        }
    }

    public UsuarioDto getUsuarioDto() {
        return usuarioDto;
    }
}
