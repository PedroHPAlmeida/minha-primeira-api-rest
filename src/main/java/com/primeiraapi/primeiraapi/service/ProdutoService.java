package com.primeiraapi.primeiraapi.service;

import com.primeiraapi.primeiraapi.entity.Produto;
import com.primeiraapi.primeiraapi.repository.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private IProdutoRepository produtoRepository;

    public Produto salvar(Produto produto){ return produtoRepository.save(produto); }

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id){
        return produtoRepository.findById(id);
    }

    public Optional<Produto> buscarProdutoPorNome(Produto produto){
        return produtoRepository.findByNome(produto.getNome());
    }

    public void removerPorId(Long id){
        produtoRepository.deleteById(id);
    }

}
