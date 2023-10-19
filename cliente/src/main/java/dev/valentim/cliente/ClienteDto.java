package dev.valentim.cliente;

import dev.valentim.usuario.Usuario;
import dev.valentim.usuario.dto.UsuarioConfigDto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ClienteDto extends UsuarioConfigDto {
    private BigDecimal saldo;

    public ClienteDto() {
        // TODO estudar como vai ficar a vinculação dos usuarios
        super.configurarUsuario();
        long saldoInicial = 1000L;
        this.saldo = BigDecimal.valueOf(saldoInicial);
    }

}
