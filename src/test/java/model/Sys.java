package model;

public class Sys {
    private int type;
    private int id;
    private Double message;
    private String country;
    private int sunrise;
    private int sundet;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getSunrise() {
        return sunrise;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public int getSundet() {
        return sundet;
    }

    public void setSundet(int sundet) {
        this.sundet = sundet;
    }
}
