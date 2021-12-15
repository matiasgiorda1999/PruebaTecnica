package Tests;

import junit.framework.TestCase;
import Class.*;

import java.util.*;

public class TestBill extends TestCase {
    private Bill bill;
    private Country countryArg;
    private Country countryBra;
    private Location locationCor;
    private Location locationBra;
    private Location locationBsAs;
    private Date dateInit;
    private Date dateFinish;
    private InternationalCall internationalCall;
    private NationalCall nationalCall;
    private LocalCall localCall;
    private ArrayList<Call> calls;
    private Subscription subscription;
    private Date date;

    public void scene(){
        subscription = new Subscription(1,"Premium", 2499.99f);
        calls = new ArrayList<>();
        countryArg = new Country("Argentina",5.0f);
        countryBra = new Country("Brasil",2.5f);
        locationCor = new Location("Cordoba",countryArg,1.5f);
        locationBra = new Location("Brasilia",countryBra,0.5f);
        dateInit = new Date(121,11,14,10,0,20);
        dateFinish = new Date(121,11,14,10,5,45);
        internationalCall = new InternationalCall(1,dateInit,dateFinish,locationCor,locationBra);
        calls.add(internationalCall);
        date = new Date(2021,11,31);
        bill = new Bill(1,date,"Jose Manuel Perez",subscription,calls);
    }

    public void sceneAddNationalCall(){;
        locationBsAs = new Location("Buenos Aires",countryArg,0.5f);
        dateInit = new Date(121,11,14,10,0,59);
        dateFinish = new Date(121,11,14,12,15,15);
        nationalCall = new NationalCall(2,dateInit,dateFinish,locationCor,locationBsAs);
        bill.addCall(nationalCall);
    }

    public void sceneAddsLocalCall(){;
        dateInit = new Date(121,11,8,12,0,39);
        dateFinish = new Date(121,11,8,12,10,39);
        localCall = new LocalCall(3,dateInit,dateFinish,locationCor,locationCor);
        bill.addCall(localCall);
        dateInit = new Date(121,11,11,12,0,39);
        dateFinish = new Date(121,11,11,12,10,39);
        localCall = new LocalCall(4,dateInit,dateFinish,locationCor,locationCor);
        bill.addCall(localCall);
        dateInit = new Date(121,11,10,19,0,0);
        dateFinish = new Date(121,11,11,1,10,0);
        localCall = new LocalCall(5,dateInit,dateFinish,locationCor,locationCor);
        bill.addCall(localCall);
        dateInit = new Date(121,11,5,23,0,0);
        dateFinish = new Date(121,11,6,10,0,0);
        localCall = new LocalCall(6,dateInit,dateFinish,locationCor,locationCor);
        bill.addCall(localCall);
    }

    public void testConstructor() {
        scene();
        assertTrue(bill.getNumberBill() == 1 && bill.getSubscription().equals(subscription) && bill.getCalls().equals(calls));
    }

    public void testAddCall(){
        scene();
        assertTrue(bill.getCalls().toArray().length == 1);
        sceneAddNationalCall();
        assertTrue(bill.getCalls().toArray().length == 2);
    }

    public void testRemoveCall(){
        scene();
        sceneAddNationalCall();
        bill.removeCall(nationalCall);
        assertTrue(bill.getCalls().toArray().length == 1);
    }

    public void testCalculateCallsPrice(){
        scene();
        sceneAddNationalCall();
        sceneAddsLocalCall();
        assertTrue(bill.calculateCallsPrice() == 204.47f);
    }

    public void testCalculateTotalPrice(){
        scene();
        sceneAddNationalCall();
        sceneAddsLocalCall();
        assertTrue(bill.calculateTotalPrice() == (204.47f+2499.99f));
    }
}
