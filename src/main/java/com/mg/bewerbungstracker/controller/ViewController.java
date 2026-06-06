package com.mg.bewerbungstracker.controller;

import com.mg.bewerbungstracker.model.Bewerbung;
import com.mg.bewerbungstracker.model.BewerbungsStatus;
import com.mg.bewerbungstracker.service.BewerbungService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ViewController {

    private final BewerbungService service;

    public ViewController(BewerbungService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(
            @RequestParam(required = false)
            String suche,

            @RequestParam(required = false)
            BewerbungsStatus status,
            Model model
    ) {

        List<Bewerbung> bewerbungen;

        if (suche != null && !suche.isBlank()) {
            bewerbungen = service.sucheFirma(suche);
        }
        else if (status != null) {
            bewerbungen = service.findeNachStatus(status);
        }
        else {
            bewerbungen = service.alleBewerbungen();
        }
        model.addAttribute("bewerbungen", bewerbungen);
        model.addAttribute("gesamt", service.anzahlGesamt());
        model.addAttribute("offen", service.anzahlStatus(BewerbungsStatus.OFFEN));
        model.addAttribute("beworben", service.anzahlStatus(BewerbungsStatus.BEWORBEN));
        model.addAttribute("interview", service.anzahlStatus(BewerbungsStatus.INTERVIEW));
        model.addAttribute("angebot", service.anzahlStatus(BewerbungsStatus.ANGEBOT));
        model.addAttribute("abgelehnt", service.anzahlStatus(BewerbungsStatus.ABGELEHNT));
        return "index";
    }
}