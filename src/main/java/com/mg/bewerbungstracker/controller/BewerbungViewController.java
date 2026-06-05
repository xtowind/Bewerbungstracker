package com.mg.bewerbungstracker.controller;

import com.mg.bewerbungstracker.model.Bewerbung;
import com.mg.bewerbungstracker.service.BewerbungService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BewerbungViewController {

    private final BewerbungService service;

    public BewerbungViewController(BewerbungService service) {
        this.service = service;
    }

    @PostMapping("/bewerbungen")
    public String speichern(@Valid Bewerbung bewerbung, BindingResult result) {
        if(result.hasErrors()) {
            return "index";
        }
        service.speichern(bewerbung);
        return "redirect:/";
    }

    @PostMapping("/bewerbungen/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.loeschen(id);
        return "redirect:/";
    }

    @GetMapping("/bewerbungen/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Bewerbung bewerbung = service.findeNachId(id);
        model.addAttribute("bewerbung", bewerbung);
        return "edit";
    }

    @PostMapping("/bewerbungen/update/{id}")
    public String update(@PathVariable Long id, Bewerbung bewerbung) {
        service.aktualisieren(id, bewerbung);
        return "redirect:/";
    }
}