package com.primeiraapi.primeiraapi.service;

import com.primeiraapi.primeiraapi.entity.Fornecedor;
import com.primeiraapi.primeiraapi.repository.IFornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private IFornecedorRepository fornecedorRepository;

    public Fornecedor salvar(Fornecedor fornecedor){
        return fornecedorRepository.save(fornecedor);
    }

    public List<Fornecedor> listarFornecedores(){
        return fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> buscarPorId(Long id){
        return fornecedorRepository.findById(id);
    }

    public Optional<Fornecedor> buscarFornecedorPorNome(Fornecedor fornecedor){
        return fornecedorRepository.findByNome(fornecedor.getNome());
    }

    public void removerPorId(Long id){
        fornecedorRepository.deleteById(id);
    }
}
