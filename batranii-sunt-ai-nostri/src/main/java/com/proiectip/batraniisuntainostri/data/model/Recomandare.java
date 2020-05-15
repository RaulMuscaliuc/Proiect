package com.proiectip.batraniisuntainostri.data.model;

import com.proiectip.batraniisuntainostri.data.model.persoane.Pacient;

import javax.persistence.*;

@Entity
@Table(name = "recomandari")
public class Recomandare {

    @Id
    @GeneratedValue
    private long Id;

    @ManyToOne
    private Pacient pacient;
}
