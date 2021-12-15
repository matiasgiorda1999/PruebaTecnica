package Class;

import java.util.Date;

public class NationalCall extends Call {

    public NationalCall(int callNumber, Date dateInit, Date dateFinish, Location locationSource, Location locationDestiny) {
        super(callNumber, dateInit, dateFinish, locationSource, locationDestiny);
    }

    @Override
    public double calculatePrice() {
        return Math.floor(((this.calculateDuration()/60) * getLocationDestiny().getCost()) * 100)/100;
    }
}
