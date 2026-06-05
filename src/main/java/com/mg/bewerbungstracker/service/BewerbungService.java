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
}
