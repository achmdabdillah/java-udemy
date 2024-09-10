package dev.abdillah;

class Satellite implements OrbitEarth {

    FlightStages stage = FlightStages.GROUNDED;
    @Override
    public void achieveOrbit() {
        transition("Orbit Achieved!");
    }

    @Override
    public void takeOff() {
        transition("Taking off");
        fly();
    }

    @Override
    public void land() {
        transition("Landing");
    }

    @Override
    public void fly() {
        achieveOrbit();
        transition("Data Collection while Orbiting");
        land();
    }

    public void transition(String description) {
        System.out.println(description);
        stage = transition(stage);
        stage.track();
    }
}
