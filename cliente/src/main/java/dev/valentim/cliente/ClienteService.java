package dev.valentim.cliente;

import dev.valentim.cliente.validacoes.SaldoInicialMil;
import dev.valentim.cliente.validacoes.ValidacaoCriacaoDoCliente;
import dev.valentim.usuario.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ClienteService {

    private final ModelMapper modelMapper;

    private final ClienteRepository clienteRepository;

    private final List<ValidacaoCriacaoDoCliente> validacoes;

    public ClienteService(final ModelMapper modelMapper, final ClienteRepository clienteRepository) {
        this.modelMapper = modelMapper;
        this.clienteRepository = clienteRepository;
        this.validacoes = setValidacoes();
    }

    public void salvar() {
        ClienteDto clienteDto = new ClienteDto();
        Cliente cliente = modelMapper.map(clienteDto, Cliente.class);
        validacoes(cliente);
        clienteRepository.save(cliente);
    }

    private List<ValidacaoCriacaoDoCliente> setValidacoes() {
        List<ValidacaoCriacaoDoCliente> listaDeValidacoes = new ArrayList<>();
        listaDeValidacoes.add(new SaldoInicialMil());
        //listaDeValidacoes.add(new SomenteUmClientePorUsuario(clienteRepository));
        return listaDeValidacoes;
    }

    private void validacoes(Cliente cliente) {
        validacoes.forEach(validacao -> {
            validacao.validacao(cliente);
        });
    }
}
