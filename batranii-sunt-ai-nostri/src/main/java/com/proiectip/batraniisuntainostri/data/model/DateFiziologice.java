package com.proiectip.batraniisuntainostri.data.model;

import com.proiectip.batraniisuntainostri.data.model.persoane.Pacient;

import javax.persistence.*;

@Entity
@Table(name = "date_fiziologice")
public class DateFiziologice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @ManyToOne
    private Pacient pacient;

    @Column(name = "tensiune")
    private int tensiune;

    @Column(name = "puls")
    private int puls;

    @Column(name = "temperatura")
    private float temperatura;

    @Column(name = "greutate")
    private float greutate;

    @Column(name = "glicemie")
    private int glicemie;

    public int getTensiune() {
        return tensiune;
    }

    public long getId() {
        return id;
    }

    public void setTensiune(int tensiune) {
        this.tensiune = tensiune;
    }

    public int getPuls() {
        return puls;
    }

    public void setPuls(int puls) {
        this.puls = puls;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public float getGreutate() {
        return greutate;
    }

    public void setGreutate(float greutate) {
        this.greutate = greutate;
    }

    public int getGlicemie() {
        return glicemie;
    }

    public void setGlicemie(int glicemie) {
        this.glicemie = glicemie;
    }

}
