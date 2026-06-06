package com.mg.bewerbungstracker.service;

import com.mg.bewerbungstracker.model.Bewerbung;
import com.mg.bewerbungstracker.model.BewerbungsStatus;
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

    public List<Bewerbung> findeNachStatus(BewerbungsStatus status) {
        return  repository.findByStatus(status);
    }

    public List<Bewerbung> sucheFirma(String firma) {
        return repository.findByFirmaContainingIgnoreCase(firma);
    }

    public long anzahlGesamt() {
        return repository.count();
    }

    public long anzahlStatus(BewerbungsStatus status) {
        return repository.countByStatus(status);
    }
}
