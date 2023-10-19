package dev.valentim.cliente.validacoes;//package com.picpay.picpaydesafio.validacoes.cliente;


import dev.valentim.cliente.Cliente;
import dev.valentim.cliente.ClienteRepository;
import dev.valentim.cliente.exceptions.ClienteValidacoesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SomenteUmClientePorUsuario implements ValidacaoCriacaoDoCliente {

    private final ClienteRepository clienteRepository;

    @Autowired
    public SomenteUmClientePorUsuario(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void validacao(Cliente cliente) {
        boolean hasClientePorUsuario = clienteRepository.findClienteByUsuarioId(cliente.getUsuario().getId());
        if (hasClientePorUsuario) {
            throw new ClienteValidacoesException.ClienteExistenteException();
        }
    }
}
