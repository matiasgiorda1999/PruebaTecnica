package Class;

import java.util.Date;

public abstract class Call {
    private int callNumber;
    private Date dateInit;
    private Date dateFinish;
    private Location locationSource;
    private Location locationDestiny;

    public Call(int callNumber, Date dateInit, Date dateFinish, Location locationSource, Location locationDestiny){
        this.callNumber = callNumber;
        this.dateInit = dateInit;
        this.dateFinish = dateFinish;
        this.locationSource = locationSource;
        this.locationDestiny = locationDestiny;
    }

    public int getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(int callNumber) {
        this.callNumber = callNumber;
    }

    public Date getDateInit() {
        return dateInit;
    }

    public void setDateInit(Date dateInit) {
        this.dateInit = dateInit;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }

    public Location getLocationSource() {
        return locationSource;
    }

    public void setLocationSource(Location locationSource) {
        this.locationSource = locationSource;
    }

    public Location getLocationDestiny() {
        return locationDestiny;
    }

    public void setLocationDestiny(Location locationDestiny) {
        this.locationDestiny = locationDestiny;
    }

    public float calculateDuration(){
        long l=this.dateFinish.getTime()-this.dateInit.getTime();
        long day=l/(24*60*60*1000);
        long hour=(l/(60*60*1000)-day*24);
        long min=((l/(60*1000))-day*24*60-hour*60);
        long s=(l/1000-day*24*60*60-hour*60*60-min*60);
        float seconds = s + min * 60 + hour * 60 * 60 + day * 24 * 60 * 60;
        return seconds;
    }
    abstract public double calculatePrice();

    @Override
    public String toString() {
        return "Call\n" +
                "callNumber=" + callNumber +
                "\ndateInit=" + dateInit +
                "\ndateFinish=" + dateFinish +
                "\nlocationSource=" + locationSource +
                "\nlocationDestiny=" + locationDestiny +
                "\nduration= " + this.calculateDuration() +
                "\nprice= " + this.calculatePrice();
    }
}
