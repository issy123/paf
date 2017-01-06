/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanics;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ismail
 */
public class CommandParser implements CommandParseable {
/**
     * The singleton object.
     */
    private static final CommandParser instance = new CommandParser();

    /**
     * A list of commands.
     */
    private final ArrayList<Command> commands = new ArrayList<>();

    private CommandParser() {
        /*
         * Empty
         */
    }
    
    public static CommandParser getInstance(){
        return instance;
    }
    /**
     * Register a command.
     * @param command The command to register.
     */
    public void register(Command command) {
        commands.add(command);
    }

    /**
     * Parse the argued text to execute a command.
     * @param text The text to parse.
     */
    @Override
    public String parse(String text) {
        for(Command command : commands) {
            if (text.contains(command.name()) && text.indexOf(command.name()) == 0) {
                String[] tempArguments = text.substring(command.name().length()).trim().split(" ");
                ArrayList<String> arguments = new ArrayList<>();
                for(String arg : tempArguments) {
                    String formatted = arg.trim();
                    if (!formatted.isEmpty()) {
                        arguments.add(formatted);
                    }
                }
                String[] requiredArguments = command.requiredArguments();
                String[] allArguments = command.arguments();
                if (arguments.size() > allArguments.length) {
                    return "Too much arguments, required: " + Arrays.toString(requiredArguments) + ".";
                } else if (arguments.size() < requiredArguments.length) {
                    return "Not enough arguments, required: " + Arrays.toString(requiredArguments) + ".";
                }
                try {
                    command.execute(arguments.toArray(new String[0]));
                } catch (Exception e) {
                    return e.getMessage();
                }
                return "";
            }
        }
        return "Invalid command entered.";
    }
}
