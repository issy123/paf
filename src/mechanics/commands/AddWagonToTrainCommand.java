package mechanics.commands;

import mechanics.Command;
import mechanics.CommandParser;
import mechanics.Logger;
import mechanics.TrainFacade;

public class AddWagonToTrainCommand implements Command {

    @Override
    public void execute(String[] arguments) throws Exception {
        TrainFacade.getInstance().addWagon(arguments[0], arguments[2]);
        Logger.log("Wagon " + arguments[1] + " has been added to train " + arguments[0] + ".");
    }

    @Override
    public String name() {
        return "add";
    }

    @Override
    public String[] requiredArguments() {
        return new String[]{ "wagon name", "to", "train name" };
    }

    @Override
    public String[] arguments() {
        return this.requiredArguments();
    }

}
