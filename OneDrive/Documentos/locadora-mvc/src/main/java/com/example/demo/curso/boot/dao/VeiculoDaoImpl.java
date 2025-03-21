package com.example.demo.curso.boot.dao;

import com.example.demo.curso.boot.domain.Veiculo;
import com.example.demo.curso.boot.util.PaginacaoUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VeiculoDaoImpl extends AbstractDao<Veiculo, Long> implements VeiculoDao {

    @Override
    public PaginacaoUtil<Veiculo> buscaPaginada(int pagina, String direcao) {
        int tamanho = 5;
        int inicio = (pagina - 1) * tamanho;
        List<Veiculo> veiculos = getEntityManager()
                .createQuery("select v from Veiculo v order by v.modelo " + direcao, Veiculo.class)
                .setFirstResult(inicio)
                .setMaxResults(tamanho)
                .getResultList();

        long totalRegistros = count();
        long totalDePaginas = (totalRegistros + (tamanho - 1)) / tamanho;

        return new PaginacaoUtil<>(tamanho, pagina, totalDePaginas, direcao, veiculos);
    }

    private long count() {
        return getEntityManager()
                .createQuery("select count(*) from Veiculo", Long.class)
                .getSingleResult();
    }
}
