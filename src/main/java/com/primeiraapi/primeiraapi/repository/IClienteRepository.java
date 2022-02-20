package com.primeiraapi.primeiraapi.repository;

import com.primeiraapi.primeiraapi.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByNome(String nome);
}
