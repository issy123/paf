/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanics;

import mechanics.commands.*;
import mechanics.shape.ShapeFactory;
import mechanics.shape.shapes.*;

/**
 *
 * @author ismail
 */
public class Main {
    private CommandParser commandParser = CommandParser.getInstance();
    public void start(){
        registerCommands();
        registerShapes();
    }
    private void registerCommands(){
        commandParser.register(new NewTrainCommand());
        commandParser.register(new DeleteTrainCommand());
        commandParser.register(new NewWagonCommand());
        commandParser.register(new AddWagonToTrainCommand());
        commandParser.register(new TrainNumSeats());
        commandParser.register(new WagonNumSeats());
        commandParser.register(new DeleteWagonCommand());
        commandParser.register(new NewPassengerWagon());
        commandParser.register(new NewFreightWagon());
    }
    private void registerShapes(){
        ShapeFactory.register("train", new TrainShape());
        ShapeFactory.register("wagon", new WagonShape());
        ShapeFactory.register("passenger_wagon", new PassengerWagonShape());
        ShapeFactory.register("freight_wagon", new FreightWagonShape());
    }
}
