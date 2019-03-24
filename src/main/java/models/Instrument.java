package models;

import daos.DTO;

public class Instrument implements DTO {

    private int id;
    private String instrument;
    private String type;
    private String madeBy;
    private int yearMade;
    private int yearPurchased;
    private String owner;

    public Instrument() {
    }

    public Instrument(int id, String instrument, String type, String madeBy, int yearMade, int yearPurchased, String owner) {
        this.id = id;
        this.instrument = instrument;
        this.type = type;
        this.madeBy = madeBy;
        this.yearMade = yearMade;
        this.yearPurchased = yearPurchased;
        this.owner = owner;
    }

    public Instrument(String instrument, String type, String madeBy, int yearMade, int yearPurchased, String owner) {
        this.instrument = instrument;
        this.type = type;
        this.madeBy = madeBy;
        this.yearMade = yearMade;
        this.yearPurchased = yearPurchased;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getInstrumentType() {
        return type;
    }

    public void setInstrumentType(String type) {
        this.type = type;
    }

    public String getMadeBy() {
        return madeBy;
    }

    public void setMadeBy(String madeBy) {
        this.madeBy = madeBy;
    }

    public int getYearMade() {
        return yearMade;
    }

    public void setYearMade(int yearMade) {
        this.yearMade = yearMade;
    }

    public int getYearPurchased() {
        return yearPurchased;
    }

    public void setYearPurchased(int yearPurchased) {
        this.yearPurchased = yearPurchased;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString(){
        return this.instrument + " "
                + this.type + " "
                + this.madeBy + " "
                + this.yearMade + " "
                + this.yearPurchased + " "
                + this.owner;
    }
}

