package com.proiectip.batraniisuntainostri.data.model;

public class Tratament {

    private long id;

    private long pacient;

    private String observatiiMedic;

    private String observatiiIngrijitor;

    private int oraRezolvare;

    private boolean rezolvat;

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

    public String getObservatiiMedic() {
        return observatiiMedic;
    }

    public void setObservatiiMedic(String observatiiMedic) {
        this.observatiiMedic = observatiiMedic;
    }

    public String getObservatiiIngrijitor() {
        return observatiiIngrijitor;
    }

    public void setObservatiiIngrijitor(String observatiiIngrijitor) {
        this.observatiiIngrijitor = observatiiIngrijitor;
    }

    public int getOraRezolvare() {
        return oraRezolvare;
    }

    public void setOraRezolvare(int oraRezolvare) {
        this.oraRezolvare = oraRezolvare;
    }

    public boolean getRezolvat() {
        return rezolvat;
    }

    public void setRezolvat(boolean rezolvat) {
        this.rezolvat = rezolvat;
    }
}
