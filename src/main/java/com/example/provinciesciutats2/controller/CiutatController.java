package com.example.provinciesciutats2.controller;

import com.example.provinciesciutats2.model.entintats.Ciutats;
import com.example.provinciesciutats2.model.repositoris.CiutatRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CiutatController {

    private final CiutatRepository ciutatRepository;
    public CiutatController(CiutatRepository ciutatRepository) {
        this.ciutatRepository = ciutatRepository;
    }
    @GetMapping("/ciutat")
    public String home(Model model) {
        Iterable<Ciutats> ciutats = ciutatRepository.findAll();
        model.addAttribute("ciutats", ciutats);
        return "LlistatCiutat";
    }

}
