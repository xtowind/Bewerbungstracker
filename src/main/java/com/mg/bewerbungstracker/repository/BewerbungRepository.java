package com.mg.bewerbungstracker.repository;

import com.mg.bewerbungstracker.model.Bewerbung;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BewerbungRepository
        extends JpaRepository<Bewerbung, Long> {
}
