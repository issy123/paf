package model;


public class PassengerWagon extends Wagon {

    public PassengerWagon(String name, int seats) {
        super(name, seats);
    }

    @Override
    public String getShape() {
        return "passenger_wagon";
    }

}
