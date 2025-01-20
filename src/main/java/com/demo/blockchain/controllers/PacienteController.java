package com.demo.blockchain.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.demo.blockchain.models.Paciente;
import com.demo.blockchain.services.PacienteService;

//import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public String listarPacientes(Model model) {
        model.addAttribute("pacientes", pacienteService.getAllPacientes());
        return "pacientes/list";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "pacientes/form";
    }

    @PostMapping
    public String guardarPaciente(@ModelAttribute Paciente paciente) {
        pacienteService.savePaciente(paciente);
        return "redirect:/pacientes";
    }
}

