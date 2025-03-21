package com.example.demo.curso.boot.service;

import com.example.demo.curso.boot.domain.Contrato;
import com.example.demo.curso.boot.service.ContratoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContratoServiceImpl implements ContratoService {

    private final List<Contrato> contratos = new ArrayList<>();

    @Override
    public void salvar(Contrato contrato) {
        contratos.add(contrato);
    }

    @Override
    public void editar(Contrato contrato) {
        contratos.removeIf(c -> c.getId().equals(contrato.getId()));
        contratos.add(contrato);
    }

    @Override
    public void excluir(Long id) {
        contratos.removeIf(c -> c.getId().equals(id));
    }

    @Override
    public Contrato buscarPorId(Long id) {
        return contratos.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Contrato> buscarTodos() {
        return contratos;
    }
}
