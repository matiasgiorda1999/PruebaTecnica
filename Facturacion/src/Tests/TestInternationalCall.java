package Tests;

import junit.framework.TestCase;
import Class.*;

import java.util.Date;


public class TestInternationalCall extends TestCase {
    private Country countrySource;
    private Country countryDestiny;
    private Location locationSource;
    private Location locationDestiny;
    private Date dateInit;
    private Date dateFinish;
    private InternationalCall internationalCall;

    public void scene(){
        countrySource = new Country("Argentina",5.0f);
        countryDestiny = new Country("Brasil",2.5f);
        locationSource = new Location("Cordoba",countrySource,1.5f);
        locationDestiny = new Location("Brasilia",countryDestiny,0.5f);
        dateInit = new Date(121,11,14,10,0,20);
        dateFinish = new Date(121,11,14,10,5,45);
        internationalCall = new InternationalCall(1,dateInit,dateFinish,locationSource,locationDestiny);
    }

    public void testConstructor(){
        scene();
        assertTrue(internationalCall.getCallNumber() == 1 &&
                internationalCall.getDateInit().equals(dateInit) &&
                internationalCall.getDateFinish().equals(dateFinish) &&
                internationalCall.getLocationSource().equals(locationSource) &&
                internationalCall.getLocationDestiny().equals(locationDestiny));
    }

    public void testCalculateDuration(){
        scene();
        assertTrue(internationalCall.calculateDuration() == 325);
    }

    public void testCalculatePrice(){
        scene();
        assertTrue(internationalCall.calculatePrice() == 13.54);
    }
}
