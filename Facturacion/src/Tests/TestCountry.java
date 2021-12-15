package Tests;

import junit.framework.TestCase;
import Class.Country;

public class TestCountry extends TestCase {
    private Country country;

    public void scene(){
        country = new Country("Argentina", 5.0f);
    }

    public void testConstructor(){
        scene();
        assertTrue(country.getName() == "Argentina" && country.getCost() == 5);
    }
}
