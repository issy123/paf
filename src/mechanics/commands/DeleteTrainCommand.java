package mechanics.commands;

import mechanics.Command;
import mechanics.CommandParser;
import mechanics.Logger;
import mechanics.TrainFacade;

public class DeleteTrainCommand implements Command {

    @Override
    public void execute(String[] arguments) throws Exception {
        TrainFacade.getInstance().deleteTrain(arguments[0]);
        Logger.log("Train " + arguments[0] + " has been deleted.");
    }

    @Override
    public String name() {
        return "delete train";
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
