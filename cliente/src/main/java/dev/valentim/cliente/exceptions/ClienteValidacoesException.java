package dev.valentim.cliente.exceptions;

public class ClienteValidacoesException extends RuntimeException {

    public ClienteValidacoesException(String message) {
        super(message);
    }

    public static class ClienteExistenteException extends ClienteValidacoesException {
        public ClienteExistenteException() {
            super("Já existe um cliente para o usuário informado");
        }
    }

    public static class SaldoInicialInvalidoException extends ClienteValidacoesException {
        public SaldoInicialInvalidoException() {
            super("O saldo inicial do cliente deve ser zero");
        }
    }

    public static class KeyExistenteException extends ClienteValidacoesException {
        public KeyExistenteException() {
            super("Já existe uma chave para o usuário informado");
        }
    }
}
