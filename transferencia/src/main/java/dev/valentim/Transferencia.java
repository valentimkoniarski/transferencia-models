package dev.valentim;

import dev.valentim.dto.TransferenciaDto;
import dev.valentim.enuns.TransferenciaStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String identifier;
    private String chaveOrigem;
    private String chaveDestino;
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
