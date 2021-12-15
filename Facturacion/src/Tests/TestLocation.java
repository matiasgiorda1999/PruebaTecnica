package Tests;

import junit.framework.TestCase;
import Class.*;

public class TestLocation extends TestCase {
    private Country country;
    private Location location;

    public void scene(){
        country = new Country("Argentina", 5.0f);
        location = new Location("Cordoba",country,2.0f);
    }

    public void testConstructor(){
        scene();
        assertTrue(location.getName() == "Cordoba"&& location.getCountry().equals(country) && location.getCost() == 2);
    }
}
