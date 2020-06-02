package com.proiectip.batraniisuntainostri.data.model.persoane;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

public class Persoana {

    private long id;

    private String nume;

    private String prenume;

    private int varsta;

    private String cnp;

    private String adresa;

    public Persoana() {
    }

    public long getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}
