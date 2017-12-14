package ita.om.jsonproject.country_module;

/**
 * Created by sasmob on 12/13/2017.
 */

public class CountryDetail {
    private String rank;
    private String population;
    private String flag;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getFlag() {
        return String.valueOf(flag);
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
