package Tests;

import junit.framework.TestCase;
import Class.*;

public class TestSubscription extends TestCase {
    private Subscription subscription;

    public void scene(){
        subscription = new Subscription(1,"Premium", 2499.99f);
    }

    public void testConstructor(){
        scene();
        assertTrue(subscription.getSubscriptionNumber() == 1 && subscription.getName() == "Premium" && subscription.getCost() == 2499.99f);
    }
}
