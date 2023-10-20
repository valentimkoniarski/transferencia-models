package dev.valentim.cliente.validacoes;

import dev.valentim.cliente.Cliente;
import dev.valentim.cliente.ClienteRepository;
import dev.valentim.cliente.exceptions.ClienteValidacoesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SomenteUmClientePorKey implements ValidacaoCriacaoDoCliente {

    private final ClienteRepository clienteRepository;

    @Autowired
    public SomenteUmClientePorKey(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void validacao(Cliente cliente) {
        boolean hasClientePorKey = clienteRepository.findClienteByKeyId(cliente.getKey().getId());
        if (hasClientePorKey) {
            throw new ClienteValidacoesException.KeyExistenteException();
        }
    }
}
