package com.proiectip.batraniisuntainostri.data.model.persoane;

import javax.persistence.*;

@Entity
@Table(name = "ingrijitori")
public class Ingrijitor extends Persoana {

    @OneToOne
    private Pacient pacient;

    public Ingrijitor() {
        super();
    }

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }
}
