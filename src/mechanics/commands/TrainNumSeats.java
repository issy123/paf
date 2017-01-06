package mechanics.commands;

import mechanics.Command;
import mechanics.CommandParser;
import mechanics.Logger;
import mechanics.TrainFacade;

public class TrainNumSeats implements Command {

    @Override
    public void execute(String[] arguments) throws Exception {
        int seats = TrainFacade.getInstance().getTrainSeats(arguments[0]);
        Logger.log("Train " + arguments[0] + " contains " + seats + " seats.");
    }

    @Override
    public String name() {
        return "getnumseats train";
    }

    @Override
    public String[] requiredArguments() {
        return new String[]{ "train name" };
    }

    @Override
    public String[] arguments() {
        return this.requiredArguments();
    }
}
