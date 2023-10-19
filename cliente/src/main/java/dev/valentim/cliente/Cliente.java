package dev.valentim.cliente;

import dev.valentim.key.Key;
import dev.valentim.usuario.Usuario;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "clientes")
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private BigDecimal saldo;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "usuario_id", unique = true)
    private Usuario usuario;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "key_id", unique = true)
    private Key key;


}
