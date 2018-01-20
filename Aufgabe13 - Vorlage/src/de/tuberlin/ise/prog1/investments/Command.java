package de.tuberlin.ise.prog1.investments;

/**
 * List of commands used in the starter Class
 */
public enum Command {
    //All commands and ther Help Text
    ADD_STOCK("Add Stock"),
    BUY_STOCK("Buy Stock"),
    CREATE_FOND("Create And buy a fond"),
    CREATE_PROPERTY("Create and buy a property"),
    SHOW_PORTFOLIO("Show portfolio"),
    SHOW_STOCKS("Show list of Stocks"),
    SHOW_SORTED_PORTFOLIO("Show Sorted Portfolio"),
    UPDATE_STOCK_VALUE("Update Stock value"),
    EXIT("EXIT");



    //help text of this command
    String helpText;
    Command(String helpText){
        this.helpText = helpText;
    }

    /**
     * This Methods converts an integer to a command,
     * if the integer is a valid value between 0 and number-of-known-commands.
     * else this method will return null
     * @param i ordinal
     * @return command for given ordinal
     */
    public static Command formOrdinal(int i){
        if(i >= 0 && i < values().length){
            return values()[i];
        } else {
            return null;
        }
    }

    /**
     * @return String in form of ordinal - helpText
     */
    @Override
    public String toString() {
        return this.ordinal()+" "+this.helpText;
    }

    /**
     * @return generates a complete list of all commands and there helpText
     */
    public static String toHelpString(){
        StringBuilder builder = new StringBuilder();
        for (Command command : values()) {
            builder.append("\t").append(command).append("\n");
        }
        return builder.toString();
    }
}
