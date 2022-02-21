package com.primeiraapi.primeiraapi.repository;

import com.primeiraapi.primeiraapi.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IFornecedorRepository extends JpaRepository<Fornecedor, Long> {
    Optional<Fornecedor> findByNome(String nome);
}
