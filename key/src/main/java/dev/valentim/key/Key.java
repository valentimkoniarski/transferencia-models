package dev.valentim.key;

import dev.valentim.cliente.Cliente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Key {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID chave;

    @OneToOne(mappedBy = "key")
    private Cliente cliente;
}
