package com.example.demo.curso.boot.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.example.demo.curso.boot.domain.Veiculo;
import com.example.demo.curso.boot.service.VeiculoService;

@Component
public class StringToVeiculoConversor implements Converter<String, Veiculo> {

    @Autowired
    private VeiculoService service;

    @Override
    public Veiculo convert(String text) {
        if (text.isEmpty()) {
            return null;
        }
        Long id = Long.valueOf(text);
        return service.buscarPorId(id);
    }
}
