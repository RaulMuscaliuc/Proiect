package com.proiectip.batraniisuntainostri.data.model;

import com.proiectip.batraniisuntainostri.data.model.persoane.Pacient;

import javax.persistence.*;


public  class DateAmbientale {

    private long id;

    private long pacient;

    private String lumina;

    private float temperatura;

    private String gaz;

    private float umiditate;

    private String proximitate;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public long getPacient() {
        return pacient;
    }

    public void setPacient(long pacient) {
        this.pacient = pacient;
    }

    public String getLumina() {
        return lumina;
    }

    public void setLumina(String lumina) {
        this.lumina = lumina;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public String getGaz() {
        return gaz;
    }

    public void setGaz(String gaz) {
        this.gaz = gaz;
    }

    public float getUmiditate() {
        return umiditate;
    }

    public void setUmiditate(float umiditate) {
        this.umiditate = umiditate;
    }

    public String getProximitate() {
        return proximitate;
    }

    public void setProximitate(String proximitate) {
        this.proximitate = proximitate;
    }
}
