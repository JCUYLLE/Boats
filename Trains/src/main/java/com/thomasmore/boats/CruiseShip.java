package com.thomasmore.boats;

import com.thomasmore.Boat;

public class CruiseShip extends Boat {

    public CruiseShip(String name, int capacity, int ticketPrice, String[] stops) {
        super(name, capacity, ticketPrice, stops);
    }

    @Override
    public int onboardPeople (int people) {
        if (currentLocation != 0) return 0;
        return super.onboardPeople(people);
    }

    @Override
    public int offboardPeople (int people) {
        if (currentLocation != stops.length -1) return 0;
        return super.offboardPeople(people);
    }
}
