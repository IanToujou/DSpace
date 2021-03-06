package net.toujoustudios.dspace.command;

import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.Collections;
import java.util.List;

public interface ICommand {

    void handle(CommandContext context);

    String getName();

    String getDescription();

    List<OptionData> getOptions();

    CommandCategory getCategory();

    default List<String> getAliases() {
        return Collections.emptyList();
    }

    default String getSyntax() {

        StringBuilder builder = new StringBuilder();
        builder.append(getName());

        for (OptionData data : getOptions()) {
            builder.append(" ");
            if (data.isRequired()) {
                builder.append("<");
                builder.append(data.getName());
                builder.append(">");
            } else {
                builder.append("[<");
                builder.append(data.getName());
                builder.append(">]");
            }
        }

        return builder.toString();

    }

}
