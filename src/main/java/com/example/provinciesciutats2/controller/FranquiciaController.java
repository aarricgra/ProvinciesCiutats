package com.example.provinciesciutats2.controller;

import com.example.provinciesciutats2.model.entintats.Ciutats;
import com.example.provinciesciutats2.model.entintats.Franquicies;
import com.example.provinciesciutats2.model.repositoris.CiutatRepository;
import com.example.provinciesciutats2.model.repositoris.FranquiciaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FranquiciaController {

    private final FranquiciaRepository franquiciaRepository;
    public FranquiciaController(FranquiciaRepository franquiciaRepository) {
        this.franquiciaRepository = franquiciaRepository;
    }
    @GetMapping("/franquicia")
    public String home(Model model) {
        Iterable<Franquicies> franquicies = franquiciaRepository.findAll();
        model.addAttribute("franquicies", franquicies);
        return "LlistatFranquicies";
    }

}
