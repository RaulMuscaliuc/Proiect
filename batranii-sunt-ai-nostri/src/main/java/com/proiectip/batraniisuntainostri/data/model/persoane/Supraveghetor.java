package com.proiectip.batraniisuntainostri.data.model.persoane;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "supraveghetori")
public class Supraveghetor extends Persoana {

    @OneToMany
    private List<Pacient> pacienti;

    public Supraveghetor() {
        super();
    }

    public List<Pacient> getPacienti() {
        return pacienti;
    }

    public void setPacienti(List<Pacient> pacienti) {
        this.pacienti = pacienti;
    }
}
