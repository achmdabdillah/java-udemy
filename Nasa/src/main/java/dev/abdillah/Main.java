package dev.abdillah;

public class Main {
    public static void main(String[] args) {
//        inFlight(new Jet());

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
        flier.takeOff();
    }
}