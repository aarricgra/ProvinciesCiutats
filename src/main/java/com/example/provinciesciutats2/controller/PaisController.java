package com.example.provinciesciutats2.controller;

import com.example.provinciesciutats2.model.entintats.Ciutats;
import com.example.provinciesciutats2.model.entintats.Paisos;
import com.example.provinciesciutats2.model.repositoris.CiutatRepository;
import com.example.provinciesciutats2.model.repositoris.PaisosRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaisController {

    private final PaisosRepository paisosRepository;
    public PaisController(PaisosRepository paisosRepository) {
        this.paisosRepository = paisosRepository;
    }
    @GetMapping("/pais")
    public String home(Model model) {
        Iterable<Paisos> paisos = paisosRepository.findAll();
        model.addAttribute("paisos", paisos);
        return "LlistatPais";
    }

}
