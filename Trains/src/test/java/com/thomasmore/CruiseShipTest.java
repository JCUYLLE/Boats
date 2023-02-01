package com.thomasmore;

import com.thomasmore.boats.CruiseShip;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CruiseShipTest {
    //mensen kunnen instappen in het 1e station
    @Test
    public void testBoardAtFirstStop(){
        Boat boat = new CruiseShip("Boat", 10, 1, new String[]{"A","B", "C", "D"});
        boat.currentLocation = 0;
        int people = 5;
        int result = boat.onboardPeople(people);
        assertEquals(people, result);
        assertEquals(people, boat.getPeopleOnBoat());
    }
    //mensen kunnen enkel instappen in het begin en eindstation
    @Test
    public void testBoardAtIntermediateStop(){
        Boat boat = new CruiseShip("Boat", 10, 1, new String[]{"A","B", "C", "D"});
        boat.currentLocation = 1;
        int result = boat.onboardPeople(5);
        assertEquals(0, result);
    }
}
