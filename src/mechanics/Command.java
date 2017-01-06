package mechanics;

public interface Command {

    /**
     * Execute this command.
     * @param arguments The arguments.
     * @throws Exception Throws an exception.
     */
    void execute(String[] arguments) throws Exception;

    /**
     * Get the name of this command.
     * @return The name.
     */
    String name();

    /**
     * Get the arguments of this command.
     * @return The arguments.
     */
    String[] requiredArguments();
    
    /**
     * Get the arguments of this command.
     * @return The arguments.
     */
    String[] arguments();
    

}
