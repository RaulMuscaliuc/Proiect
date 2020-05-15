package com.proiectip.batraniisuntainostri.data.model;

import com.proiectip.batraniisuntainostri.data.model.persoane.Pacient;

import javax.persistence.*;

@Entity
@Table(name = "date_fiziologice")
public class DateFiziologice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private Pacient pacient;

    private int tensiune;

    private int puls;

    private float temperatura;

    private float greutate;

    private int glicemie;

}
