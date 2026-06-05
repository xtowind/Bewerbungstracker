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

    @GetMapping("/{id}")
    public Bewerbung getById(@PathVariable Long id) {
        return service.findeNachId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.loeschen(id);
    }

    @PutMapping("/{id}")
    public Bewerbung update(@PathVariable Long id, @RequestBody Bewerbung bewerbung) {
        return service.aktualisieren(id, bewerbung);
    }
}
