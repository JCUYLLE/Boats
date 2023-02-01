package com.thomasmore;

import com.thomasmore.boats.SpeedBoat;
import com.thomasmore.boats.CruiseShip;
import com.thomasmore.boats.PassengerBoat;

import static com.thomasmore.BoatFactory.createBoat;

class BoatSimulator {

    public static void main(String args[]) {
        Boat[] boats = new Boat[4];
        boats[0] = BoatFactory.createBoat("Antwerpen-Brussel", 10, 1, new String[]{"Antwerpen", "Mechelen", "Brussel"});
        boats[1] = BoatFactory.createBoat("Hasselt-Oostende", 10, 1, new String[]{"Hasselt", "Antwerpen", "Gent", "Brugge", "Oostende"});
        boats[2] = BoatFactory.createBoat("Egypt Cruise", 5, 10, new String[]{"The Pyramids of Giza", "Luxor", "Valley of the Kings", "Cairo"});
        boats[3] = BoatFactory.createBoat("Antwerpen Fast", 20, 20, new String[]{"Kruibeke", "Antwerpen", "Lillo"});
        int rides = 10;
        for (Boat boat : boats) {
            boat.onboardPeople((int) Math.round(Math.random()*5));
            System.out.println(boat.toString());
        }
        for (int i = 1; i <= rides; i ++) {
            System.out.println(" --------- Starting simulation " + i + " ---------");
            for (Boat boat : boats) {
                boat.ride();
                boat.offboardPeople((int) Math.round(Math.random()*5));
                boat.onboardPeople((int) Math.round(Math.random()*5));
                System.out.println(boat.toString());
            }
            System.out.println(" --------- Stopping simulation " + i + " ---------");
        }
        }
}