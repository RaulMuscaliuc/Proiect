package com.proiectip.batraniisuntainostri.data.model;

import com.proiectip.batraniisuntainostri.data.model.persoane.Pacient;

import javax.persistence.*;

public class DateFiziologice {

    private long id;

    private long pacient;

    private int tensiune;

    private int puls;

    private float temperatura;

    private float greutate;

    private int glicemie;

    public long getPacient() {
        return pacient;
    }

    public void setPacient(long pacient) {
        this.pacient = pacient;
    }

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
