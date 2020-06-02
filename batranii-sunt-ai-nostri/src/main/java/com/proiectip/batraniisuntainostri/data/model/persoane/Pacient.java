package com.proiectip.batraniisuntainostri.data.model.persoane;

import com.proiectip.batraniisuntainostri.data.model.*;

import javax.persistence.*;
import java.util.List;

public class Pacient extends Persoana {

    private List<Diagnostic> diagnostice;

    private List<Tratament> tratamente;

    private List<Alergie> alergii;

    private List<Recomandare> recomandari;

    private List<DateFiziologice> dateFiziologice;

    private List<DateAmbientale> dateAmbientale;

    private long medic;

    private long ingrijitor;

    private long supraveghetor;

    public long getSupraveghetor() {
        return supraveghetor;
    }

    public void setSupraveghetor(long supraveghetor) {
        this.supraveghetor = supraveghetor;
    }

    public long getMedic() {
        return medic;
    }

    public void setMedic(long medic) {
        this.medic = medic;
    }

    public long getIngrijitor() {
        return ingrijitor;
    }

    public void setIngrijitor(long ingrijitor) {
        this.ingrijitor = ingrijitor;
    }

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

    public List<DateAmbientale> getDateAmbientale() {
        return dateAmbientale;
    }

    public void setDateAmbientale(List<DateAmbientale> dateAmbientale) {
        this.dateAmbientale = dateAmbientale;
    }
}
