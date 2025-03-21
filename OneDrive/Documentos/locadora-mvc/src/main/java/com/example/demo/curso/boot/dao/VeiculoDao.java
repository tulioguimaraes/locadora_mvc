package com.example.demo.curso.boot.dao;

import com.example.demo.curso.boot.domain.Veiculo;
import com.example.demo.curso.boot.util.PaginacaoUtil;

import java.util.List;

public interface VeiculoDao {

    void save(Veiculo veiculo);

    void update(Veiculo veiculo);

    void delete(Long id);

    Veiculo findById(Long id);

    List<Veiculo> findAll();

    PaginacaoUtil<Veiculo> buscaPaginada(int pagina, String direcao);
}
