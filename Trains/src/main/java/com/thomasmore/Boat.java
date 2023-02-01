package com.thomasmore;

public abstract class Boat {

    public String name;
    public int capacity;
    public int ticketPrice;
    public int balance;

    protected String[] stops;
    protected int peopleOnBoat;
    protected int currentLocation;
    protected int direction;

    // Constructor

    public Boat(String name, int capacity, int ticketPrice, String[] stops) {
        this.name = name;
        this.capacity = capacity;
        this.ticketPrice = ticketPrice;
        this.stops = stops;
        this.currentLocation = 0;
        this.balance = 0;
        this.peopleOnBoat = 0;
        this.direction = 1;
    }

    // Getters

    public int getPeopleOnBoat() {
        return peopleOnBoat;
    }

    public String getCurrentLocation() {
        return stops[currentLocation];
    }

    // Function members

    public int onboardPeople (int people) {
        if (people < 0) return 0;
        // Een boot heeft beperkte capaciteit
        people = Math.min(capacity- peopleOnBoat, people);
        // Iedereen die kan opstappen, betaalt een kaartje
        for (int i = 0; i < people; i++) payTicket();
        // Het nieuwe aantal mensen op de boot wordt vermeerderd met de instappers
        peopleOnBoat += people;
        return people;
    }

    public int offboardPeople (int people) {
        if (people < 0) return 0;
        // Een boot kan nooit onder capaciteit gaan.
        people = Math.min(peopleOnBoat, people);
        // Het nieuwe aantal mensen op de boot wordt vermeerderd met de instappers
        peopleOnBoat -= people;
        return people;
    }

    public void payTicket() {
        this.balance += this.ticketPrice;
    }

    public void ride() {
        // Bij de eerste halte is de richting voorwaarts
        if (currentLocation == 0) direction = 1;
        // Bij de laatste halte is de richting achterwaarts
        if (currentLocation == this.stops.length - 1) direction = -1;
        // Vaar naar de volgende bestemming
        this.currentLocation += this.direction;
    }

   @Override
   public String toString() {
        return this.name + " met capaciteit voor " + this.capacity+ " personen en een prijs van "
                + this.ticketPrice + " euro staat op " + stops[currentLocation]
                + ", momenteel zijn er " + this.getPeopleOnBoat() + " mensen aan boord en staat de balans op "
                + this.balance + " euro.";
    }


}
