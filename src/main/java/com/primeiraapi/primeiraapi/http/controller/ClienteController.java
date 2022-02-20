package com.primeiraapi.primeiraapi.http.controller;

import com.primeiraapi.primeiraapi.entity.Cliente;
import com.primeiraapi.primeiraapi.service.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody Cliente cliente){
        return clienteService.salvar(cliente);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alterarClientePorId(@PathVariable("id") Long id, @RequestBody Cliente cliente){
        clienteService.buscarClientePorId(id)
                .map(clienteBase -> {
                    modelMapper.map(cliente, clienteBase);
                    clienteService.salvar(clienteBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> listarClientes(){
        return clienteService.listarClientes();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente buscarClientePorId(@PathVariable("id") Long id){
        return clienteService.buscarClientePorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
    }

    @GetMapping(path = "/nome")
    @ResponseStatus(HttpStatus.OK)
    public Cliente buscarClientePorNome(@RequestBody Cliente cliente){
        return clienteService.buscarClientePorNome(cliente)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerClientePorId(@PathVariable("id") Long id){
        clienteService.buscarClientePorId(id)
                .map(cliente -> {
                    clienteService.removerClientePorId(id);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
    }

}
