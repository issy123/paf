/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ismail
 */
public class Train {

    private String name;

    private ArrayList<Wagon> wagons = new ArrayList<>();

    public Train(String name) {
        this.name = name;
    }

    public boolean add(Wagon wagon) {
        wagon.setTrain(this);
        return wagons.add(wagon);
    }

    public Wagon get(String name) {
        for(Wagon wagon : wagons) {
            if (wagon.getName().equals(name)) {
                return wagon;
            }
        }
        return null;
    }

    public int getSeats() {
        int total = 0;
        for(Wagon wagon : wagons) {
            total += wagon.getSeats();
        }
        return total;
    }

    public Wagon remove(String name) {
        for(Wagon wagon : wagons) {
            if (wagon.getName().equals(name)) {
                wagon.setTrain(null);
                wagons.remove(wagon);
                return wagon;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public List<Wagon> getWagons() {
        return wagons;
    }

    public String wagonsToString() {
        if(wagons.isEmpty()){
            return "No wagons";
        }
        String wagonsToString = "[";
        for(Wagon wagon : wagons){
            wagonsToString += "Name: " + wagon.getName() + " Seats: " + wagon.getSeats() + " Shape: " + wagon.getShape();
        }
        wagonsToString += "]";
        return wagonsToString;
    }

}
