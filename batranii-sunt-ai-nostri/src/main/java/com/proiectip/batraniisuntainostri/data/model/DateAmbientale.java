package com.proiectip.batraniisuntainostri.data.model;

import com.proiectip.batraniisuntainostri.data.model.persoane.Pacient;

import javax.persistence.*;

@Entity
@Table(name = "date_ambientale")
public  class DateAmbientale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private Pacient pacient;

    private boolean lumina;

    private int temperatura;

    private boolean gaz;

    private boolean umiditate;

    private boolean proximitate;
}
