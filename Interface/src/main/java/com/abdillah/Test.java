package com.abdillah;

public class Test {
    public static void main(String[] args) {
        inFlight(new Jet());

//        OrbitEarth.log("Testing" + new Satellite());
        System.out.println("-".repeat(30));
        orbit(new Satellite());
    }
    public static void inFlight(FlightEnabled flier) {
        flier.takeOff();
        flier.transition(FlightStages.CRUISE);
        flier.fly();
        if(flier instanceof Trackable tracked) {
            tracked.track();
        }
        flier.land();
    }

    public static void orbit(OrbitEarth flier) {
        flier.takeOff(); /* 1 transition */
        flier.fly(); /* 2 transition */
        flier.land(); /* 1 transition */
    }
}
