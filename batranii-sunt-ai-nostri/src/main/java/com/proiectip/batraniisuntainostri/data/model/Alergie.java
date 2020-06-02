package com.proiectip.batraniisuntainostri.data.model;

import com.proiectip.batraniisuntainostri.data.model.persoane.Pacient;

import javax.persistence.*;

public class Alergie {

    private long id;

    private String nume;

    private long pacient;

    public long getPacient() {
        return pacient;
    }

    public long getId() {
        return id;
    }

    public void setPacient(long pacient) {
        this.pacient = pacient;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}
