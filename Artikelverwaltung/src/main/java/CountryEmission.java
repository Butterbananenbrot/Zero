import java.io.Serializable;

class CountryEmission implements Serializable {
    private String country;
    private double emissions;

    public CountryEmission(String country, double emissions) {
        this.country = country;
        this.emissions = emissions;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getEmissions() {
        return emissions;
    }

    public void setEmissions(double emissions) {
        this.emissions = emissions;
    }
}