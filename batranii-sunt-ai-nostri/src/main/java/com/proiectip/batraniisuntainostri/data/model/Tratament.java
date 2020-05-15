package com.proiectip.batraniisuntainostri.data.model;

import com.proiectip.batraniisuntainostri.data.model.persoane.Pacient;

import javax.persistence.*;

@Entity
@Table(name = "tratamente")
public class Tratament {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Pacient pacient;
}
