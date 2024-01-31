package com.example.provinciesciutats2.controller;

import com.example.provinciesciutats2.model.entintats.Ciutats;
import com.example.provinciesciutats2.model.entintats.Provincies;
import com.example.provinciesciutats2.model.repositoris.CiutatRepository;
import com.example.provinciesciutats2.model.repositoris.ProvinciesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProvinciaController {

    private final ProvinciesRepository provinciesRepository;
    public ProvinciaController(ProvinciesRepository provinciesRepository) {
        this.provinciesRepository = provinciesRepository;
    }
    @GetMapping("/provincia")
    public String home(Model model) {
        Iterable<Provincies> provincies = provinciesRepository.findAll();
        model.addAttribute("provincies", provincies);
        return "LlistatProvincia";
    }

}
