package Class;
public class Country {

    private String name;
    private float cost;

    public Country(String name,float cost){
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public float getCost() {
        return cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Country" +
                "\nname='" + name +
                "\ncost=" + cost;
    }

}
