package com.example.demo.curso.boot.dao;

import com.example.demo.curso.boot.domain.Cliente;
import com.example.demo.curso.boot.util.PaginacaoUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteDaoImpl extends AbstractDao<Cliente, Long> implements ClienteDao {

    @Override
    public PaginacaoUtil<Cliente> buscaPaginada(int pagina, String direcao) {
        int tamanho = 5;
        int inicio = (pagina - 1) * tamanho;
        List<Cliente> clientes = getEntityManager()
                .createQuery("select c from Cliente c order by c.nome " + direcao, Cliente.class)
                .setFirstResult(inicio)
                .setMaxResults(tamanho)
                .getResultList();

        long totalRegistros = count();
        long totalDePaginas = (totalRegistros + (tamanho - 1)) / tamanho;

        return new PaginacaoUtil<>(tamanho, pagina, totalDePaginas, direcao, clientes);
    }

    private long count() {
        return getEntityManager()
                .createQuery("select count(*) from Cliente", Long.class)
                .getSingleResult();
    }
    
    @Override
    public List<Cliente> findAll() {
        return getEntityManager().createQuery("from Cliente", Cliente.class).getResultList();
    }
}
