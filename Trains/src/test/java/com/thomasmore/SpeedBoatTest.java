package com.thomasmore;

import com.thomasmore.boats.SpeedBoat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpeedBoatTest {
    //boot stopt enkel in het eindstation
    @Test
    public void trainGoesFromBeginToEndWithoutStops(){
        Boat boat = new SpeedBoat("Boat", 10, 1, new String[]{"A","B", "C", "D"});
        boat.ride();
        assertEquals("D", boat.getCurrentLocation());
    }
    //boot mag niet stoppen in tussenstation
    //Deze test moet falen om te slagen
    @Test
    public void trainCannotStopHalfway(){
        Boat boat = new SpeedBoat("Boat", 10, 1, new String[]{"A","B", "C", "D"});
        boat.ride();
        assertEquals("B", boat.getCurrentLocation());
    }

}
