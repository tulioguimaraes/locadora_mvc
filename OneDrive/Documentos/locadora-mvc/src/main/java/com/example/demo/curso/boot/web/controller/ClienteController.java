package com.example.demo.curso.boot.web.controller;

import com.example.demo.curso.boot.domain.Cliente;
import com.example.demo.curso.boot.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cadastrar")
    public String cadastrar(Cliente cliente) {
        return "/cliente/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
    	List<Cliente> clientes = clienteService.buscarTodos();
        System.out.println("Clientes carregados: " + clientes);
    	model.addAttribute("clientes", clienteService.buscarTodos());
        return "/cliente/lista";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Cliente cliente, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/cliente/cadastro";
        }
        clienteService.salvar(cliente);
        attr.addFlashAttribute("success", "Cliente cadastrado com sucesso.");
        return "redirect:/clientes/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("cliente", clienteService.buscarPorId(id));
        return "/cliente/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Cliente cliente, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/cliente/cadastro";
        }
        clienteService.editar(cliente);
        attr.addFlashAttribute("success", "Cliente atualizado com sucesso.");
        return "redirect:/clientes/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        clienteService.excluir(id);
        attr.addFlashAttribute("success", "Cliente excluído com sucesso.");
        return "redirect:/clientes/listar";
    }
}
