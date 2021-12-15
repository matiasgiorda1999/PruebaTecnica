package Tests;

import junit.framework.TestCase;

import java.util.Date;
import Class.*;

public class TestNationalCall extends TestCase {
    private Country country;
    private Location locationSource;
    private Location locationDestiny;
    private Date dateInit;
    private Date dateFinish;
    private NationalCall nationalCall;

    public void scene(){
        country = new Country("Argentina",5.0f);
        locationSource = new Location("Cordoba",country,1.5f);
        locationDestiny = new Location("Buenos Aires",country,0.5f);
        dateInit = new Date(121,11,14,10,0,59);
        dateFinish = new Date(121,11,14,12,15,15);
        nationalCall = new NationalCall(1,dateInit,dateFinish,locationSource,locationDestiny);
    }

    public void testConstructor(){
        scene();
        assertTrue(nationalCall.getCallNumber() == 1 &&
                nationalCall.getDateInit().equals(dateInit) &&
                nationalCall.getDateFinish().equals(dateFinish) &&
                nationalCall.getLocationSource().equals(locationSource) &&
                nationalCall.getLocationDestiny().equals(locationDestiny));
    }

    public void testCalculateDuration(){
        scene();
        assertTrue(nationalCall.calculateDuration() == 8056);
    }

    public void testCalculatePrice(){
        scene();
        assertTrue(nationalCall.calculatePrice() == 67.13);
    }
}
