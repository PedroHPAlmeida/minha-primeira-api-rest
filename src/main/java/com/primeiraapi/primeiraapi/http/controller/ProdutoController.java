package com.primeiraapi.primeiraapi.http.controller;

import com.primeiraapi.primeiraapi.entity.Produto;
import com.primeiraapi.primeiraapi.service.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto salvar(@RequestBody Produto produto){
        return produtoService.salvar(produto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alterarProdutoPorId(@PathVariable("id") Long id, @RequestBody Produto produto){
        produtoService.buscarPorId(id)
                .map(produtoBase -> {
                    modelMapper.map(produto, produtoBase);
                    produtoService.salvar(produtoBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado."));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> listarProdutos(){
        return produtoService.listarProdutos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Produto buscarProdutoPorId(@PathVariable("id") Long id){
        return produtoService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado."));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerProduto(@PathVariable("id") Long id){
        produtoService.buscarPorId(id)
                .map(produto -> {
                    produtoService.removerPorId(id);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado."));
    }
}
