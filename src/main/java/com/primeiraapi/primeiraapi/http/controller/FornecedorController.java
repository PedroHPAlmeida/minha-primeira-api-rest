package com.primeiraapi.primeiraapi.http.controller;

import com.primeiraapi.primeiraapi.entity.Fornecedor;
import com.primeiraapi.primeiraapi.service.FornecedorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fornecedor salvar(@RequestBody Fornecedor fornecedor){
        return fornecedorService.salvar(fornecedor);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alterarFornecedorPorId(@PathVariable("id") Long id, @RequestBody Fornecedor fornecedor){
        fornecedorService.buscarPorId(id)
                .map(fornecedorBase -> {
                    modelMapper.map(fornecedor, fornecedorBase);
                    fornecedorService.salvar(fornecedorBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado."));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Fornecedor> listarFornecedores(){
        return fornecedorService.listarFornecedores();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Fornecedor buscarFornecedorPorId(@PathVariable("id") Long id){
        return fornecedorService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado."));
    }

    @GetMapping(path = "/nome")
    @ResponseStatus(HttpStatus.OK)
    public Fornecedor buscarFornecedorPorNome(@RequestBody Fornecedor fornecedor){
        return fornecedorService.buscarFornecedorPorNome(fornecedor)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado."));
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerFornecedorPorId(@PathVariable("id") Long id){
        fornecedorService.buscarPorId(id)
                .map(fornecedor -> {
                    fornecedorService.removerPorId(id);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado."));
    }
}
