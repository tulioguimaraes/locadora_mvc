package com.example.demo.curso.boot.dao;

import com.example.demo.curso.boot.domain.Contrato;
import com.example.demo.curso.boot.util.PaginacaoUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContratoDaoImpl extends AbstractDao<Contrato, Long> implements ContratoDao {

    @Override
    public PaginacaoUtil<Contrato> buscaPaginada(int pagina, String direcao) {
        int tamanho = 5;
        int inicio = (pagina - 1) * tamanho;
        List<Contrato> contratos = getEntityManager()
                .createQuery("select c from Contrato c order by c.dataInicio " + direcao, Contrato.class)
                .setFirstResult(inicio)
                .setMaxResults(tamanho)
                .getResultList();

        long totalRegistros = count();
        long totalDePaginas = (totalRegistros + (tamanho - 1)) / tamanho;

        return new PaginacaoUtil<>(tamanho, pagina, totalDePaginas, direcao, contratos);
    }

    private long count() {
        return getEntityManager()
                .createQuery("select count(*) from Contrato", Long.class)
                .getSingleResult();
    }
}
