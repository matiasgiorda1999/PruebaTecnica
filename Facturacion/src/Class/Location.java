package Class;
import Class.Country;

public class Location {
    private String name;
    private Country country;
    private float cost;

    public Location(String name,Country country,float cost){
        this.name = name;
        this.country = country;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Location\n" +
                "name='" + name +
                "\ncountry=" + country +
                "\ncost=" + cost;
    }
}
