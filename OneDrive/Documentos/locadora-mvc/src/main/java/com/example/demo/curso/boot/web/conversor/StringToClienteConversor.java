package com.example.demo.curso.boot.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.example.demo.curso.boot.domain.Cliente;
import com.example.demo.curso.boot.service.ClienteService;

@Component
public class StringToClienteConversor implements Converter<String, Cliente> {

    @Autowired
    private ClienteService service;

    @Override
    public Cliente convert(String text) {
        if (text.isEmpty()) {
            return null;
        }
        Long id = Long.valueOf(text);
        return service.buscarPorId(id);
    }
}
