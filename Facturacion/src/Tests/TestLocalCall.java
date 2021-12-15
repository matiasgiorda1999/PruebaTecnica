package Tests;

import junit.framework.TestCase;
import Class.*;

import java.util.Date;

public class TestLocalCall extends TestCase {
    private Country country;
    private Location location;
    private Date dateInit;
    private Date dateFinish;
    private LocalCall localCall;

    public void sceneJobDayTime(){
        country = new Country("Argentina",5.0f);
        location = new Location("Cordoba",country,1.5f);
        dateInit = new Date(121,11,8,12,0,39);
        dateFinish = new Date(121,11,8,12,10,39);
        localCall = new LocalCall(1,dateInit,dateFinish,location,location);
    }

    public void sceneNoJobDayTime(){
        dateInit = new Date(121,11,11,12,0,39);
        dateFinish = new Date(121,11,11,12,10,39);
        localCall = new LocalCall(1,dateInit,dateFinish,location,location);
    }

    public void sceneInitJDTFinishNoJDT(){
        dateInit = new Date(121,11,10,19,0,0);
        dateFinish = new Date(121,11,11,1,10,0);
        localCall = new LocalCall(1,dateInit,dateFinish,location,location);
    }

    public void sceneInitNoJDTFinishJDT(){
        dateInit = new Date(121,11,5,23,0,0);
        dateFinish = new Date(121,11,6,10,0,0);
        localCall = new LocalCall(1,dateInit,dateFinish,location,location);
    }

    public void testConstructor(){
        sceneJobDayTime();
        assertTrue(localCall.getCallNumber() == 1 &&
                localCall.getDateInit().equals(dateInit) &&
                localCall.getDateFinish().equals(dateFinish) &&
                localCall.getLocationSource().equals(location) &&
                localCall.getLocationDestiny().equals(location));
    }

    public void testCalculateDuration(){
        sceneJobDayTime();
        assertTrue(localCall.calculateDuration() == 600);
    }

    public void testCalculatePrice(){
        sceneJobDayTime();
        assertTrue(localCall.calculatePrice() == 2.0);
        sceneNoJobDayTime();
        assertTrue(localCall.calculatePrice() == 1.0);
        sceneInitJDTFinishNoJDT();
        assertTrue(localCall.calculatePrice() == 42.9);
        sceneInitNoJDTFinishJDT();
        assertTrue(localCall.calculatePrice() == 77.9);
    }
}
