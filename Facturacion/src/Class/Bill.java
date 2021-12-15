package Class;

import java.util.ArrayList;
import java.util.Date;

public class Bill {
    private int numberBill;
    private Date date;
    private String client;
    private Subscription subscription;
    private ArrayList<Call> calls;

    public Bill(int numberBill, Date date, String client, Subscription subscription, ArrayList<Call> calls) {
        this.numberBill = numberBill;
        this.date = date;
        this.client = client;
        this.subscription = subscription;
        this.calls = calls;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public int getNumberBill() {
        return numberBill;
    }

    public void setNumberBill(int numberBill) {
        this.numberBill = numberBill;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public ArrayList<Call> getCalls() {
        return calls;
    }

    public void setCalls(ArrayList<Call> calls) {
        this.calls = calls;
    }

    public void addCall(Call call){
        this.calls.add(call);
    }

    public void removeCall(Call call){
        this.calls.remove(call);
    }

    public float calculateCallsPrice(){
        float price = 0;
        for(int i=0; i < this.calls.toArray().length ; i++){
            price = (float) (price + this.calls.get(i).calculatePrice());
        }
        return price;
    }

    public float calculateTotalPrice(){
        return this.calculateCallsPrice() + this.getSubscription().getCost();
    }

    public String getBillInform(){
        return "Bill n°" + numberBill +
                "\n year: " + date.getYear() + " - month: " + (date.getMonth()+1) +
                "\n Client: " + client +
                "\n Detail: " +
                "\n   Subscription name: " + subscription.getName() +
                "\n   Amount of subscription: $" + subscription.getCost() +
                "\n   Number of Calls: " + this.calls.toArray().length +
                "\n   Amount of calls: $" + this.calculateCallsPrice() +
                "\n Total amount (Ammount of calls + Subscription cost): $" + this.calculateTotalPrice();
    }

    @Override
    public String toString() {
        return "Bill\n" +
                "numberBill=" + numberBill +
                "\ndate=" + date +
                "\nclient='" + client +
                "\nsubscription=" + subscription +
                "\ncalls=" + calls;
    }
}
