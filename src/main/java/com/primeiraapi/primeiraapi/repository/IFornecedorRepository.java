package com.primeiraapi.primeiraapi.repository;

import com.primeiraapi.primeiraapi.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFornecedorRepository extends JpaRepository<Fornecedor, Long> {
}
