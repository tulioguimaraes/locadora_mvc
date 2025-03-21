package com.example.demo.curso.boot.service;

import com.example.demo.curso.boot.domain.Veiculo;
import java.util.List;

public interface VeiculoService {

    void salvar(Veiculo veiculo);
    
    void editar(Veiculo veiculo);
    
    void excluir(Long id);
    
    Veiculo buscarPorId(Long id);
    
    List<Veiculo> buscarTodos();
}
