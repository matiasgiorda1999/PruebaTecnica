package Class;

public class Subscription {
    private int subscriptionNumber;
    private String name;
    private float cost;

    public Subscription(int subscriptionNumber, String name, float cost) {
        this.subscriptionNumber = subscriptionNumber;
        this.name = name;
        this.cost = cost;
    }

    public int getSubscriptionNumber() {
        return subscriptionNumber;
    }

    public void setSubscriptionNumber(int subscriptionNumber) {
        this.subscriptionNumber = subscriptionNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Subscription\n" +
                "subscriptionNumber=" + subscriptionNumber +
                "\nname='"+
                "\ncost=" + cost;
    }
}
