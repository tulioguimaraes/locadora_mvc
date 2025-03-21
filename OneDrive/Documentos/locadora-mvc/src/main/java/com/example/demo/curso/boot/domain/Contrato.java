package com.example.demo.curso.boot.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name = "contrato")
public class Contrato extends AbstractEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "cli_codigo", nullable = false)
    private Cliente cliente;
    
    @NotNull
	@PastOrPresent(message = "{PastOrPresent.funcionario.dataEntrada}")
	@DateTimeFormat(iso = ISO.DATE)
    @Column(name = "con_datainicio", nullable = false)
    private LocalDate dataInicio;
    
    @DateTimeFormat(iso = ISO.DATE)
    @Column(name = "con_datafim", nullable = false)
    private LocalDate dataFim;
    
    @NotNull
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(name = "con_valorcontrato", nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
    private BigDecimal valorContrato;

    // Getters e Setters
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }

    public LocalDate getDataFim() { return dataFim; }
    public void setDataFim(LocalDate dataFim) { this.dataFim = dataFim; }

    public BigDecimal getValorContrato() { return valorContrato; }
    public void setValorContrato(BigDecimal valorContrato) { this.valorContrato = valorContrato; }
}
