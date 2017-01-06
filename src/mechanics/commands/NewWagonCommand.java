package mechanics.commands;

import mechanics.Command;
import mechanics.CommandParser;
import mechanics.Logger;
import mechanics.TrainFacade;
import model.Wagon;

public class NewWagonCommand implements Command {

    @Override
    public void execute(String[] arguments) throws Exception {
        int seats = 20;
        if(arguments.length == 2){
            throw new Exception("Invalid use of command '" + this.name() + "'");
        }
        if(arguments.length == 3){
            if(!arguments[1].equals("numseats")){
                throw new Exception("unknown argument '" + arguments[1] + "' did you mean 'numseats'?");
            }
            try {
                seats = Integer.parseInt(arguments[2]);
            } catch(Exception e) {
                throw new Exception("Number of seats are invalid.");
            }
            
        }
        Wagon wagon = TrainFacade.getInstance().createWagon(arguments[0], seats);
        Logger.log("Wagon " + arguments[0] + " has been created with " + wagon.getSeats() + " seats.");
    }

    @Override
    public String name() {
        return "new wagon";
    }

    @Override
    public String[] requiredArguments() {
        return new String[]{ "wagon name" };
    }

    @Override
    public String[] arguments() {
        return new String[]{ "<wagon name>", "numseats", "<num seats>" };
    }
}
