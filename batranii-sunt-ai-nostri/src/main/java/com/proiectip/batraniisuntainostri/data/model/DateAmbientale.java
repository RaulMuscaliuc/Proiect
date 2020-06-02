package com.proiectip.batraniisuntainostri.data.model;

import com.proiectip.batraniisuntainostri.data.model.persoane.Pacient;

import javax.persistence.*;


public  class DateAmbientale {

    private long id;

    private long pacient;

    private boolean lumina;

    private int temperatura;

    private boolean gaz;

    private boolean umiditate;

    private boolean proximitate;

    public long getId() {
        return id;
    }

    public long getPacient() {
        return pacient;
    }

    public void setPacient(long pacient) {
        this.pacient = pacient;
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
