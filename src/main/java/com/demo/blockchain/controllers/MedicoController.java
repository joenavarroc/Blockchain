package com.demo.blockchain.controllers;

import com.demo.blockchain.models.Medico;
import com.demo.blockchain.services.MedicoService;
import org.springframework.stereotype.Controller;  // Cambié esta importación
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  // Cambié esta anotación de @RestController a @Controller
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    // Ver la lista de médicos
    @GetMapping
    public String listarMedicos(Model model) {
        model.addAttribute("medicos", medicoService.getAllMedicos());
        return "medicos/list";  // Vista con la lista de médicos
    }

    // Mostrar el formulario para agregar un nuevo médico
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("medico", new Medico());
        return "medicos/form";  // Vista para agregar nuevo médico
    }

    // Guardar un nuevo médico
    @PostMapping
    public String guardarMedico(@ModelAttribute Medico medico) {
        medicoService.saveMedico(medico);  // Guardar médico y agregarlo a la blockchain
        return "redirect:/medicos";  // Redireccionar a la lista de médicos
    }

    // Ver la blockchain (toda la cadena de bloques)
    @GetMapping("/blockchain")
    public String verBlockchain(Model model) {
        model.addAttribute("blockchain", medicoService.getBlockchain().getChain());  // Obtener la cadena de bloques
        return "blockchain/list";  // Vista que muestra la blockchain
    }

    @GetMapping("/blockchain/validate")
    public String validarBlockchain(Model model) {
    boolean esValida = medicoService.validarBlockchain();
    String resultado = esValida ? "La blockchain es válida." : "La blockchain está corrupta.";

    // Pasar el resultado de la validación
    model.addAttribute("resultado", resultado);

    // Pasar los bloques de la blockchain
    model.addAttribute("blockchain", medicoService.getBlockchain().getChain());

    return "blockchain/validate";  // Redirige a la vista 'validate.html'
    }


}
