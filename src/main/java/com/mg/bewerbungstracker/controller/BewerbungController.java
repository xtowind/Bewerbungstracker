package com.mg.bewerbungstracker.controller;

import com.mg.bewerbungstracker.model.Bewerbung;
import com.mg.bewerbungstracker.service.BewerbungService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/bewerbungen")
public class BewerbungController {

    private final BewerbungService service;

    public BewerbungController(BewerbungService service) {
        this.service = service;
    }

    @GetMapping
    public List<Bewerbung> getAll() {
        return service.alleBewerbungen();
    }

    @PostMapping
    public Bewerbung speichern(@RequestBody Bewerbung bewerbung) {
        return service.speichern(bewerbung);
    }
}
