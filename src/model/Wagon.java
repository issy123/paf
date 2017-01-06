/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ismail
 */
public class Wagon {

    private Train train;

    private final String name;

    private final int seats;

    public Wagon(String name, int seats) {
        this.name = name;
        this.seats = seats;
    }

    public String getShape() {
        return "wagon";
    }

    public String getName() {
        return name;
    }

    public int getSeats() {
        return seats;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Train getTrain() {
        return train;
    }

}
