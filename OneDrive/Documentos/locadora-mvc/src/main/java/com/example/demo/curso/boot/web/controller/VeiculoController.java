package com.example.demo.curso.boot.web.controller;

import com.example.demo.curso.boot.domain.Veiculo;
import com.example.demo.curso.boot.service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping("/cadastrar")
    public String cadastrar(Veiculo veiculo) {
        return "/veiculo/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("veiculos", veiculoService.buscarTodos());
        return "/veiculo/lista";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Veiculo veiculo, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/veiculo/cadastro";
        }
        veiculoService.salvar(veiculo);
        attr.addFlashAttribute("success", "Veículo cadastrado com sucesso.");
        return "redirect:/veiculos/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("veiculo", veiculoService.buscarPorId(id));
        return "/veiculo/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Veiculo veiculo, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/veiculo/cadastro";
        }
        veiculoService.editar(veiculo);
        attr.addFlashAttribute("success", "Veículo atualizado com sucesso.");
        return "redirect:/veiculos/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        veiculoService.excluir(id);
        attr.addFlashAttribute("success", "Veículo excluído com sucesso.");
        return "redirect:/veiculos/listar";
    }
}
