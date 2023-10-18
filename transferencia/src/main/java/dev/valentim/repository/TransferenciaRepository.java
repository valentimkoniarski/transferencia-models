package dev.valentim.repository;

import dev.valentim.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Integer> {
    Transferencia findByIdentifier(String identifier);
}
