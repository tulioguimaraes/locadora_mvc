package com.example.demo.curso.boot.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.example.demo.curso.boot.domain.Contrato;
import com.example.demo.curso.boot.service.ContratoService;

@Component
public class StringToContratoConversor implements Converter<String, Contrato> {

    @Autowired
    private ContratoService service;

    @Override
    public Contrato convert(String text) {
        if (text.isEmpty()) {
            return null;
        }
        Long id = Long.valueOf(text);
        return service.buscarPorId(id);
    }
}
