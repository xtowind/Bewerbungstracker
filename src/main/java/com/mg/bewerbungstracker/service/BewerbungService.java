package com.mg.bewerbungstracker.service;

import com.mg.bewerbungstracker.model.Bewerbung;
import com.mg.bewerbungstracker.repository.BewerbungRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BewerbungService {

    private final BewerbungRepository repository;

    public BewerbungService(BewerbungRepository repository) {
        this.repository = repository;
    }

    public Bewerbung speichern(Bewerbung bewerbung) {
        return repository.save(bewerbung);
    }

    public List<Bewerbung> alleBewerbungen() {
        return repository.findAll();
    }

    public Bewerbung findeNachId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void loeschen(Long id) {
        repository.deleteById(id);
    }

    public Bewerbung aktualisieren(Long id, Bewerbung neueBewerbung) {
        Bewerbung vorhandeneBewerbung = repository.findById(id).orElse(null);
        if(vorhandeneBewerbung == null) {
            return null;
        }
        vorhandeneBewerbung.setFirma(neueBewerbung.getFirma());
        vorhandeneBewerbung.setDatum(neueBewerbung.getTitel());
        vorhandeneBewerbung.setDatum(neueBewerbung.getDatum());
        vorhandeneBewerbung.setStatus(neueBewerbung.getStatus());
        return repository.save(vorhandeneBewerbung);
    }
}
