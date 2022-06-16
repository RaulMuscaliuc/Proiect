package com.proiectip.batraniisuntainostri.data.model;

import com.proiectip.batraniisuntainostri.data.model.persoane.Pacient;

import javax.persistence.*;

public class Recomandare {

    private long Id;

    private long pacient;

    private String tipRecomandare;

    private String indicatii;

    private int durataZilnica;

    private int frecventa;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getTipRecomandare() {
        return tipRecomandare;
    }

    public void setTipRecomandare(String tipRecomandare) {
        this.tipRecomandare = tipRecomandare;
    }

    public String getIndicatii() {
        return indicatii;
    }

    public void setIndicatii(String indicatii) {
        this.indicatii = indicatii;
    }

    public int getDurataZilnica() {
        return durataZilnica;
    }

    public void setDurataZilnica(int durataZilnica) {
        this.durataZilnica = durataZilnica;
    }

    public int getFrecventa() {return frecventa;}

    public void setFrecventa(int frecventa) {this.frecventa = frecventa;}

    public long getPacient() {
        return pacient;
    }

    public void setPacient(long pacient) {
        this.pacient = pacient;
    }
}
