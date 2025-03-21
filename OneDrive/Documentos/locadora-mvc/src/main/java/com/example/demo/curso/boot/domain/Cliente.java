package com.example.demo.curso.boot.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cli_codigo;

    @Column(name = "cli_nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "cli_endereco", length = 50)
    private String endereco;

    @Column(name = "cli_telefone", length = 50)
    private String telefone;

    @Column(name = "cli_cpf", length = 50, unique = true, nullable = false)
    private String cpf;

    // Getters e Setters
    public Long getId() { return cli_codigo; }
    public void setId(Long id) { this.cli_codigo = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
}
