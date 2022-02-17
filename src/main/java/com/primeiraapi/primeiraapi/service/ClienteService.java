package com.primeiraapi.primeiraapi.service;

import com.primeiraapi.primeiraapi.entity.Cliente;
import com.primeiraapi.primeiraapi.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarClientePorId(Long id){
        return clienteRepository.findById(id);
    }

    public void removerClientePorId(Long id){
        clienteRepository.deleteById(id);
    }
}
