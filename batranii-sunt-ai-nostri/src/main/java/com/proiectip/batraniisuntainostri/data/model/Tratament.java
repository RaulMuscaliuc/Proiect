package com.proiectip.batraniisuntainostri.data.model;

import com.proiectip.batraniisuntainostri.data.model.persoane.Pacient;

import javax.persistence.*;

@Entity
@Table(name = "tratamente")
public class Tratament {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @ManyToOne
    private Pacient pacient;

    @Column(name = "observatii_medic")
    private String observatiiMedic;

    @Column(name = "observatii_ingrijitor")
    private String observatiiIngrijitor;

    @Column(name = "ora_rezolvare")
    private int oraRezolvare;

    @Column(name = "rezolvat")
    private boolean rezolvat;

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }

    public long getId() {
        return id;
    }

    public String getObservatiiMedic() {
        return observatiiMedic;
    }

    public void setObservatiiMedic(String observatiiMedic) {
        this.observatiiMedic = observatiiMedic;
    }

    public String getObservatiiIngrijitor() {
        return observatiiIngrijitor;
    }

    public void setObservatiiIngrijitor(String observatiiIngrijitor) {
        this.observatiiIngrijitor = observatiiIngrijitor;
    }

    public int getOraRezolvare() {
        return oraRezolvare;
    }

    public void setOraRezolvare(int oraRezolvare) {
        this.oraRezolvare = oraRezolvare;
    }

    public boolean isRezolvat() {
        return rezolvat;
    }

    public void setRezolvat(boolean rezolvat) {
        this.rezolvat = rezolvat;
    }
}
