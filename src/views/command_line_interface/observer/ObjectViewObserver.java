/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.command_line_interface.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.control.TextArea;
import mechanics.TrainFacade;
import model.Train;
import model.Wagon;

/**
 *
 * @author ismail
 */
public class ObjectViewObserver implements Observer{
    TextArea display;
    public ObjectViewObserver(TextArea display){
        this.display = display;
    }
    @Override
    public void update(Observable o, Object arg) {
        display.setText("");
        TrainFacade trainFacade = (TrainFacade) o;
        display.appendText("\nTrains:");
        printTrains(trainFacade.getTrains());
        //loop through all trains, and output the props
        display.appendText("\nWagons:");
        printWagons(trainFacade.getWagons());
        //loop through all unattached wagons and output the props
        //update object view
    }
    private void printTrains(ArrayList<Train> trains){
        if(trains.isEmpty()){
            output("No Trains");
        }
        trains.forEach((train) -> {
            String wagonsToString = "";
            List<Wagon> wagons = train.getWagons();
            for(int i = 0; i < wagons.size(); i++){
                Wagon wagon = wagons.get(i);
                wagonsToString += "\n    Name: "+wagon.getName() + " Seats: " + wagon.getSeats() + " Type: " + wagon.getShape();
                if(i + 1 < wagons.size()){
                    wagonsToString += ", ";
                }else{
                    wagonsToString += "\n";
                }
            }
            if(wagons.isEmpty()){
                wagonsToString = "No wagons";
            }
            
            output("Name: " + train.getName() + " Wagons: [" + wagonsToString + "]");
            
        });
    }
    
    private void printWagons(Map<String, Wagon> wagons){
        if(wagons.isEmpty()){
            output("No wagons");
        }
        wagons.entrySet().forEach((pair) -> {
            Wagon wagon = (Wagon)pair.getValue();
            output("Name: " + pair.getKey() + " Seats: " + wagon.getSeats() + "Type: " + wagon.getShape());
        });
    }
    private void output(String text){
        if(display.getText().isEmpty()){
            display.setText(text);
        }else{
            display.appendText("\n" + text);
        }
    }
}
