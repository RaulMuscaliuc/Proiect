package com.proiectip.batraniisuntainostri.data.model.persoane;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "medici")
public class Medic extends Persoana {

    @Column(name = "specialitate")
    private String specialitate;

    @OneToMany
    private List<Pacient> pacienti;

    public Medic() {
        super();
    }

    public String getSpecialitate() {
        return specialitate;
    }

    public void setSpecialitate(String specialitate) {
        this.specialitate = specialitate;
    }

    public List<Pacient> getPacienti() {
        return pacienti;
    }

    public void setPacienti(List<Pacient> pacienti) {
        this.pacienti = pacienti;
    }
}
