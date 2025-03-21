package com.example.demo.curso.boot.service;

import com.example.demo.curso.boot.domain.Contrato;
import java.util.List;

public interface ContratoService {

    void salvar(Contrato contrato);
    
    void editar(Contrato contrato);
    
    void excluir(Long id);
    
    Contrato buscarPorId(Long id);
    
    List<Contrato> buscarTodos();
}
