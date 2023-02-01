package com.thomasmore;

import com.thomasmore.boats.PassengerBoat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassengerBoatTest {

    // Create a new boat in each test or at the beginning, constructor example below
    // Boat boat = new PassengerBoat ("Boat", 10, 1, new String[]{"A","B", "C", "D"});

    // Een nieuwe boot telkens leeg is (qua passagiers en balans)
    // Een boot effectief het aantal mensen heeft, die opgestapt zijn
    // Een boot nooit te veel mensen kan laten opstappen
    // Een boot nooit te veel mensen kan laten afstappen
    // Een passagierstboot naar het volgende station vaart
    @Test
    public void verifyEmptyBoat(){
        Boat boat = new PassengerBoat ("Boat", 10, 1, new String[]{"A","B", "C", "D"});
        int expectedPassengers = 0;
        int actualPassengers = boat.getPeopleOnBoat();
        assertEquals(expectedPassengers, actualPassengers);
    }

    @Test
    public void testAmountOfPeopleOnBoard(){
        Boat boat = new PassengerBoat ("Boat", 10, 1, new String[]{"A","B", "C", "D"});
        boat.onboardPeople(8);
        assertEquals(8, boat.getPeopleOnBoat());
    }
    @Test
    public void testMaxCapacityNotExceded(){
        Boat boat = new PassengerBoat ("Boat", 10, 1, new String[]{"A","B", "C", "D"});
        boat.onboardPeople(8);
        boat.onboardPeople(5);
        assertEquals(10, boat.getPeopleOnBoat());
    }
    @Test
    public void testMaximunPeopleOffboarding(){
        Boat boat = new PassengerBoat ("Boat", 10, 1, new String[]{"A","B", "C", "D"});
        boat.offboardPeople(7);
        assertEquals(0, boat.getPeopleOnBoat());
    }
    @Test
    public void testTrainStopsAtNextStation(){
        Boat boat = new PassengerBoat ("Boat", 10, 1, new String[]{"A","B", "C", "D"});
        boat.ride();
        assertEquals("B", boat.getCurrentLocation());
    }
}
