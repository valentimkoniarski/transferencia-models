package dev.valentim.transferencia.dto;

import dev.valentim.transferencia.enuns.TransferenciaStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class TransferenciaDto {
    private UUID identifier = UUID.randomUUID();
    private UUID chaveOrigem;
    private UUID chaveDestino;
    private Double valor;
    private LocalDateTime dataTransferencia;
    private TransferenciaStatus status;
}