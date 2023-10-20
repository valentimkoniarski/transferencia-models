package dev.valentim.cliente;//package com.picpay.picpaydesafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(value = "SELECT CASE WHEN EXISTS (SELECT * FROM clientes WHERE usuario_id = ?1) THEN TRUE ELSE FALSE END",
            nativeQuery = true)
    boolean findClienteByUsuarioId(Long usuarioId);

    @Query(value = "SELECT CASE WHEN EXISTS (SELECT * FROM clientes WHERE key_id = ?1) THEN TRUE ELSE FALSE END",
            nativeQuery = true)
    boolean findClienteByKeyId(Long keyId);

}
