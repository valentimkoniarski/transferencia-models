package dev.valentim.transferencia;

import dev.valentim.transferencia.dto.TransferenciaDto;
import dev.valentim.transferencia.enuns.TransferenciaStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID identifier;

    private UUID chaveOrigem;

    private UUID chaveDestino;

    private Double valor;

    private LocalDateTime dataTransferencia;

    @Enumerated(EnumType.STRING)
    private TransferenciaStatus status;

    public static Transferencia toEntity(TransferenciaDto pixDTO) {
        Transferencia transferencia = new Transferencia();
        transferencia.setIdentifier(pixDTO.getIdentifier());
        transferencia.setChaveDestino(pixDTO.getChaveDestino());
        transferencia.setStatus(pixDTO.getStatus());
        transferencia.setValor(pixDTO.getValor());
        transferencia.setDataTransferencia(pixDTO.getDataTransferencia());
        transferencia.setChaveOrigem(pixDTO.getChaveOrigem());
        return transferencia;
    }
}
