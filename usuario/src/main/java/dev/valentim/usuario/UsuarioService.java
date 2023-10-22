package dev.valentim.usuario;


import dev.valentim.key.Key;
import dev.valentim.usuario.dto.UsuarioDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Service
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    private final ModelMapper modelMapper;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository,
                          ModelMapper modelMapper,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("Usuario não encontrado com email %s", email)));
    }

    public void registrarUsuario(UsuarioDto usuarioDto) {
        criptografarSenha(usuarioDto);
        usuarioDto.setChave(UUID.randomUUID());
        final Usuario usuario = modelMapper.map(usuarioDto, Usuario.class);
        usuario.setKey(new Key());
        usuarioRepository.save(usuario);
    }

    private void criptografarSenha(UsuarioDto usuarioDto) {
        usuarioDto.setSenha(bCryptPasswordEncoder.encode(usuarioDto.getSenha()));
    }

    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() ->
                new UsernameNotFoundException(String.format("Usuario não encontrado com id %s", id)));
    }
}
