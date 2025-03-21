package com.example.demo.curso.boot.dao;

import com.example.demo.curso.boot.domain.Contrato;
import com.example.demo.curso.boot.util.PaginacaoUtil;

import java.util.List;

public interface ContratoDao {

    void save(Contrato contrato);

    void update(Contrato contrato);

    void delete(Long id);

    Contrato findById(Long id);

    List<Contrato> findAll();

    PaginacaoUtil<Contrato> buscaPaginada(int pagina, String direcao);
}
