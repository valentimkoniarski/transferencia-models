package dev.valentim.transferencia.repository;

import dev.valentim.transferencia.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.UUID;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Integer> {

    Transferencia findByIdentifier(UUID identifier);

    @Modifying
    @Query(value = "UPDATE clientes SET saldo =+ saldo + ?1 WHERE usuario_id = ?2", nativeQuery = true)
    void updateSaldoClienteRecebedor(Double saldo, Long usuarioId);

    @Modifying
    @Query(value = "UPDATE clientes SET saldo =+ saldo - ?1 WHERE usuario_id = ?2", nativeQuery = true)
    void updateSaldoClienteTransferidor(Double saldo, Long usuarioId);

    //@Modifying
    //@Query(value = "UPDATE lojistas SET saldo =+ saldo + ?1 WHERE usuario_id =?2", nativeQuery = true)
    //void updateSaldoLojistaRecebedor(BigDecimal saldo, Long usuarioId);


}
