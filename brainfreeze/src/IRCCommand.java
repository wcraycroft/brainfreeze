

public enum IRCCommand {
	BET_BLUE("!betblue"), BET_PURPLE("!betpurple"), GOLD("!gold"), HELLO("!hello"), CLOSE_BLUE("!winblue"), CLOSE_PURPLE("!winpurple"), NOT_COMMAND(" ");
    private final String command;

    @Override
    public String toString(){
        return command;
    }

    private IRCCommand(String command){
        this.command = command;
    }

}
