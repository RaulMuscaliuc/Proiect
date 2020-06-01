package com.proiectip.batraniisuntainostri.data.model.persoane;

import com.proiectip.batraniisuntainostri.data.model.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pacienti")
public class Pacient extends Persoana {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "pacient_id", referencedColumnName = "id")
    private List<Diagnostic> diagnostice;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "pacient_id", referencedColumnName = "id")
    private List<Tratament> tratamente;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "pacient_id", referencedColumnName = "id")
    private List<Alergie> alergii;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "pacient_id", referencedColumnName = "id")
    private List<Recomandare> recomandari;

    @OneToMany
    @JoinColumn(name = "pacient_id", referencedColumnName = "id")
    private List<DateFiziologice> dateFiziologice;

    @OneToOne
    @JoinColumn(name = "date_ambientale_id")
    private DateAmbientale dateAmbientale;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medic_id")
    private Medic medic;

    @OneToOne
    private Ingrijitor ingrijitor;

    public Pacient() {
        super();
    }

    public List<Diagnostic> getDiagnostice() {
        return diagnostice;
    }

    public void setDiagnostice(List<Diagnostic> diagnostice) {
        this.diagnostice = diagnostice;
    }

    public List<Tratament> getTratamente() {
        return tratamente;
    }

    public void setTratamente(List<Tratament> tratamente) {
        this.tratamente = tratamente;
    }

    public List<Alergie> getAlergii() {
        return alergii;
    }

    public void setAlergii(List<Alergie> alergii) {
        this.alergii = alergii;
    }

    public List<Recomandare> getRecomandari() {
        return recomandari;
    }

    public void setRecomandari(List<Recomandare> recomandari) {
        this.recomandari = recomandari;
    }

    public List<DateFiziologice> getDateFiziologice() {
        return dateFiziologice;
    }

    public void setDateFiziologice(List<DateFiziologice> dateFiziologice) {
        this.dateFiziologice = dateFiziologice;
    }

    public DateAmbientale getDateAmbientale() {
        return dateAmbientale;
    }

    public void setDateAmbientale(DateAmbientale dateAmbientale) {
        this.dateAmbientale = dateAmbientale;
    }
}
