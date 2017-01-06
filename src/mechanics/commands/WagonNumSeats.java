package mechanics.commands;

import mechanics.Command;
import mechanics.CommandParser;
import mechanics.Logger;
import mechanics.TrainFacade;

public class WagonNumSeats implements Command {

    @Override
    public void execute(String[] arguments) throws Exception {
        int seats = TrainFacade.getInstance().getWagonSeats(arguments[0]);
        Logger.log("Wagon " + arguments[0] + " contains " + seats + " seats.");
    }

    @Override
    public String name() {
        return "getnumseats wagon";
    }

    @Override
    public String[] requiredArguments() {
        return new String[]{ "unassociated wagon name" };
    }

    @Override
    public String[] arguments() {
        return this.requiredArguments();
    }
}
