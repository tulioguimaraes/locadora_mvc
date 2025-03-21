package com.example.demo.curso.boot.service;

import com.example.demo.curso.boot.domain.Cliente;
import java.util.List;

public interface ClienteService {

    void salvar(Cliente cliente);
    
    void editar(Cliente cliente);
    
    void excluir(Long id);
    
    Cliente buscarPorId(Long id);
    
    List<Cliente> buscarTodos();
}
