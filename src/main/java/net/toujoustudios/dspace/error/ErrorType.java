package net.toujoustudios.dspace.error;

public enum ErrorType {

    COMMAND_INVALID_SYNTAX("0001", "The command syntax is not correct."),
    COMMAND_INVALID_SEARCH("0002", "The given search has no results.");

    ErrorType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    private final String code;
    private final String description;

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

}
