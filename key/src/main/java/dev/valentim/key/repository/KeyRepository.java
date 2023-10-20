package dev.valentim.key.repository;

import dev.valentim.key.Key;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface KeyRepository extends JpaRepository<Key, Integer> {
    Key findByChave(UUID key);
}
