package com.mg.bewerbungstracker.repository;

import com.mg.bewerbungstracker.model.Bewerbung;
import com.mg.bewerbungstracker.model.BewerbungsStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BewerbungRepository
        extends JpaRepository<Bewerbung, Long> {
    List<Bewerbung> findByStatus(BewerbungsStatus status);
    List<Bewerbung> findByFirmaContainingIgnoreCase(String firma);
    long countByStatus(BewerbungsStatus status);
}
