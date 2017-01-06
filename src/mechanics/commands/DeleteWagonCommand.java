package mechanics.commands;

import mechanics.Command;
import mechanics.CommandParser;
import mechanics.Logger;
import mechanics.TrainFacade;

public class DeleteWagonCommand implements Command {

    @Override
    public void execute(String[] arguments) throws Exception {
        TrainFacade.getInstance().deleteWagon(arguments[0], arguments[1]);
        Logger.log("Wagon " + arguments[1] + " has been deleted from train " + arguments[0] + ".");
    }

    @Override
    public String name() {
        return "delete wagon";
    }

    @Override
    public String[] requiredArguments() {
        return new String[]{ "train name", "wagon name" };
    }

    @Override
    public String[] arguments() {
        return this.requiredArguments();
    }
}
