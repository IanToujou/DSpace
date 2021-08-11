package net.toujoustudios.dspace.command;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public interface ICommand {

    void handle(CommandContext context);

    String getName();

    String getHelp();

    String getUsage();

    boolean isNSFW();

    CommandCategory getCategory();

    default List<String> getAliases() {
        return Collections.emptyList();
    }

}
