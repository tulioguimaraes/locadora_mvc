package com.example.demo.curso.boot.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "veiculo")
public class Veiculo extends AbstractEntity<Long> {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera o valor automaticamente
    @Column(name = "vei_codigo", nullable = false)
    private Long id;
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

	@Column(name = "vei_modelo", length = 50, nullable = false)
    private String modelo;

    @Column(name = "vei_marca", length = 50, nullable = false)
    private String marca;

    @Column(name = "vei_placa", length = 50, unique = true, nullable = false)
    private String placa;

    @Column(name = "vei_valor")
    private Integer valor;

    // Getters e Setters
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public Integer getValor() { return valor; }
    public void setValor(Integer valor) { this.valor = valor; }
}
