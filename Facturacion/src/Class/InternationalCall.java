package Class;

import java.util.Date;

public class InternationalCall extends Call{

    public InternationalCall(int callNumber, Date dateInit, Date dateFinish, Location locationSource, Location locationDestiny) {
        super(callNumber, dateInit, dateFinish, locationSource, locationDestiny);
    }

    @Override
    public double calculatePrice() {
        return Math.floor(((this.calculateDuration()/60) * getLocationDestiny().getCountry().getCost()) * 100)/100;
    }
}
