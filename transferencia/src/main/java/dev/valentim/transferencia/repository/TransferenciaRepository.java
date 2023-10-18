package dev.valentim.transferencia.repository;

import dev.valentim.transferencia.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Integer> {
    Transferencia findByIdentifier(String identifier);
}
