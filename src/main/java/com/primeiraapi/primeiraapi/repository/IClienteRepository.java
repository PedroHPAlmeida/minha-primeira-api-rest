package com.primeiraapi.primeiraapi.repository;

import com.primeiraapi.primeiraapi.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {
}
