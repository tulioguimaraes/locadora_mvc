package com.example.demo.curso.boot.dao;

import com.example.demo.curso.boot.domain.Cliente;
import com.example.demo.curso.boot.util.PaginacaoUtil;

import java.util.List;

public interface ClienteDao {

    void save(Cliente cliente);

    void update(Cliente cliente);

    void delete(Long id);

    Cliente findById(Long id);

    List<Cliente> findAll();

    PaginacaoUtil<Cliente> buscaPaginada(int pagina, String direcao);
}
