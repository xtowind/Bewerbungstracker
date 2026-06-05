package com.mg.bewerbungstracker.controller;

import com.mg.bewerbungstracker.service.BewerbungService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    private final BewerbungService service;

    public ViewController(BewerbungService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("bewerbungen",service.alleBewerbungen());
        return "index";
    }
}
