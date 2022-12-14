package za.co.wethinkcode.toyrobot;

public class Command {
    private final String name;
    private final String argument;

    public Command(String name, String argument) {
        this.name = (name);
        this.argument = argument.trim().toLowerCase();
    }

    public String getName() {

        return name;
    }

    public String getArgument() {

        return this.argument;
    }

    public static Command create(String instruction) {
        String[] args = instruction.toLowerCase().trim().split(" ");
        switch (args[0]){
            case "shutdown":
                return new ShutdownCommand();
            case "help":
                return new HelpCommand();
            case "forward":
                return new ForwardCommand(args[1]);
            default:
                throw new IllegalArgumentException("Unsupported command: " + instruction);
        }
    }

    public boolean execute(Robot target) {

        return false;
    }
}
