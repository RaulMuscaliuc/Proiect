package com.proiectip.batraniisuntainostri.data.model.persoane;

import javax.persistence.*;

public class Ingrijitor extends Persoana {

    private long pacient;

    public Ingrijitor() {
        super();
    }

    public long getPacient() {
        return pacient;
    }

    public void setPacient(long pacient) {
        this.pacient = pacient;
    }
}
