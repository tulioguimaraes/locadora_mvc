package com.example.demo.curso.boot.web.controller;

import com.example.demo.curso.boot.domain.Cliente;
import com.example.demo.curso.boot.domain.Contrato;
import com.example.demo.curso.boot.service.ClienteService;
import com.example.demo.curso.boot.service.ContratoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("/contratos")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cadastrar")
    public String cadastrar(Contrato contrato) {
    	return "/contrato/cadastro";
    }
    
    @ModelAttribute("clientes")
	public List<Cliente> getCliente() {
		return clienteService.buscarTodos();
	}

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("contratos", contratoService.buscarTodos());
        return "/contrato/lista";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Contrato contrato, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/contrato/cadastro";
        }
        contratoService.salvar(contrato);
        attr.addFlashAttribute("success", "Contrato cadastrado com sucesso.");
        return "redirect:/contratos/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("contrato", contratoService.buscarPorId(id));
        return "/contrato/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Contrato contrato, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/contrato/cadastro";
        }
        contratoService.editar(contrato);
        attr.addFlashAttribute("success", "Contrato atualizado com sucesso.");
        return "redirect:/contratos/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        contratoService.excluir(id);
        attr.addFlashAttribute("success", "Contrato excluído com sucesso.");
        return "redirect:/contratos/listar";
    }
}
