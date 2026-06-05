package com.mg.bewerbungstracker.model;

import jakarta.persistence.*;

@Entity
public class Bewerbung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firma;
    private String titel;
    private String datum;
    @Enumerated(EnumType.STRING)
    private BewerbungsStatus status;

    public Bewerbung() {
    }

    public Bewerbung(String firma, String titel, String datum, BewerbungsStatus status) {
        this.firma = firma;
        this.titel = titel;
        this.datum = datum;
        this.status = status;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public BewerbungsStatus getStatus() {
        return status;
    }

    public void setStatus(BewerbungsStatus status) {
        this.status = status;
    }
}
