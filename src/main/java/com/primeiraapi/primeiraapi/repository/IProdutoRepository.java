package com.primeiraapi.primeiraapi.repository;

import com.primeiraapi.primeiraapi.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProdutoRepository extends JpaRepository<Produto, Long> {
}
