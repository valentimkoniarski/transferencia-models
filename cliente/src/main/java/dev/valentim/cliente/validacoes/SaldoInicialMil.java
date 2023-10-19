package dev.valentim.cliente.validacoes;

import dev.valentim.cliente.Cliente;
import dev.valentim.cliente.exceptions.ClienteValidacoesException;

import java.math.BigDecimal;

public class SaldoInicialMil implements ValidacaoCriacaoDoCliente {
    @Override
    public void validacao(Cliente cliente) {
        if (!isIgualAMil(cliente)) {
            throw new ClienteValidacoesException.SaldoInicialInvalidoException();
        }
    }

    private static boolean isIgualAMil(Cliente cliente) {
        final BigDecimal saldoInicialMil = BigDecimal.valueOf(1000);
        return cliente.getSaldo().equals(saldoInicialMil);
    }
}
