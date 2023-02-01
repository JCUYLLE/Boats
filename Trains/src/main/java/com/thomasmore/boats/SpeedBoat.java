package com.thomasmore.boats;

import com.thomasmore.Boat;

public class SpeedBoat extends Boat {

    public SpeedBoat(String name, int capacity, int ticketPrice, String[] stops) {
        super(name, capacity, ticketPrice, stops);
    }

    @Override
    public void ride() {
        setStartLocation();
        // Bij de eerste halte is het eindstation de bestemming
        if (currentLocation == 0) direction = this.stops.length-1;
        // Bij de laatste halte is de richting terug naar beginstation
        if (currentLocation == this.stops.length - 1) direction = (this.stops.length-1)*-1;
        // Vaar naar de volgende bestemming
        this.currentLocation += this.direction;
    }

    public void setStartLocation(){
        if (currentLocation != 0 && currentLocation != this.stops.length-1) currentLocation=0;

    }
}
