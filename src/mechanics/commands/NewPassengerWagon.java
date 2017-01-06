package mechanics.commands;

import mechanics.Command;
import mechanics.CommandParser;
import mechanics.Logger;
import mechanics.TrainFacade;
import model.Wagon;
import model.PassengerWagon;

public class NewPassengerWagon implements Command {

    @Override
    public void execute(String[] arguments) throws Exception {
        int seats;
        try {
            seats = Integer.parseInt(arguments[1]);
        } catch(Exception e) {
            throw new Exception("Number of seats are invalid.");
        }
        Wagon wagon = TrainFacade.getInstance().createWagon(new PassengerWagon(arguments[0], seats));
        Logger.log("Passenger wagon " + arguments[0] + " has been created with " + wagon.getSeats() + " seats.");
    }

    @Override
    public String name() {
        return "new passenger wagon";
    }

    @Override
    public String[] requiredArguments() {
        return new String[]{ "wagon name", "seats" };
    }

    @Override
    public String[] arguments() {
        return this.requiredArguments();
    }
}
