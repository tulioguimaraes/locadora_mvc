package com.example.demo.curso.boot.service;

import com.example.demo.curso.boot.dao.VeiculoDao;
import com.example.demo.curso.boot.domain.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class VeiculoServiceImpl implements VeiculoService {

    @Autowired
    private VeiculoDao dao;

    @Override
    public void salvar(Veiculo veiculo) {
        dao.save(veiculo);
    }

    @Override
    public void editar(Veiculo veiculo) {
        dao.update(veiculo);
    }

    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Veiculo buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Veiculo> buscarTodos() {
        return dao.findAll();
    }
}
