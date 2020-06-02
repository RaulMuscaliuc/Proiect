package com.proiectip.batraniisuntainostri.data.model;

import com.proiectip.batraniisuntainostri.data.model.persoane.Pacient;

import javax.persistence.*;

public class Diagnostic {

    private long id;

    private String nume;

    private long pacient;

    public Diagnostic() {
    }

    public long getPacient() {
        return pacient;
    }

    public void setPacient(long pacient) {
        this.pacient = pacient;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}
