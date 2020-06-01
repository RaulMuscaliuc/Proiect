package com.proiectip.batraniisuntainostri.data.model;

import com.proiectip.batraniisuntainostri.data.model.persoane.Pacient;

import javax.persistence.*;

@Entity
@Table(name = "date_ambientale")
public  class DateAmbientale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @ManyToOne
    private Pacient pacient;

    @Column(name = "lumina")
    private boolean lumina;

    @Column(name = "temperatura")
    private int temperatura;

    @Column(name = "gaz")
    private boolean gaz;

    @Column(name = "umiditate")
    private boolean umiditate;

    @Column(name = "proximitate")
    private boolean proximitate;

    public long getId() {
        return id;
    }

    public boolean isLumina() {
        return lumina;
    }

    public void setLumina(boolean lumina) {
        this.lumina = lumina;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public boolean isGaz() {
        return gaz;
    }

    public void setGaz(boolean gaz) {
        this.gaz = gaz;
    }

    public boolean isUmiditate() {
        return umiditate;
    }

    public void setUmiditate(boolean umiditate) {
        this.umiditate = umiditate;
    }

    public boolean isProximitate() {
        return proximitate;
    }

    public void setProximitate(boolean proximitate) {
        this.proximitate = proximitate;
    }
}
