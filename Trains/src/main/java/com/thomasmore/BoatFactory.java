package com.thomasmore;

import com.thomasmore.boats.CruiseShip;
import com.thomasmore.boats.PassengerBoat;
import com.thomasmore.boats.SpeedBoat;

public class BoatFactory {

    static public Boat createBoat(String name, int capacity, int ticketPrice, String[] stops){
        if (name.contains("cruise") ){
            return new CruiseShip(name, capacity, ticketPrice, stops);
        }
        else if (name.contains("fast") || name.equals("speed")){
            return new SpeedBoat(name, capacity, ticketPrice, stops);
        }
        else{
            return new PassengerBoat(name, capacity, ticketPrice, stops);
        }
    }
}

