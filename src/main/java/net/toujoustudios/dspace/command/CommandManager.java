package net.toujoustudios.dspace.command;

import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/**
 * This file has been created by Ian Toujou.
 * Project: DSpace
 * Date: 11/08/2021
 * Time: 14:45
 */
public class CommandManager {

    private final List<ICommand> commands = new ArrayList<>();

    public CommandManager() {

    }

    private void addCommand(ICommand command) {
        boolean nameFound = this.commands.stream().anyMatch((it) -> it.getName().equalsIgnoreCase(command.getName()));
        if (nameFound) throw new IllegalArgumentException("A command with this name is already present.");
        commands.add(command);
    }

    public List<ICommand> getCommands() {
        return commands;
    }

    @Nullable
    public ICommand getCommand(String search) {

        String searchLower = search.toLowerCase();

        for (ICommand command : this.commands) {
            if (command.getName().equals(searchLower) || command.getAliases().contains(searchLower)) return command;
        }

        return null;

    }

    public void handle(SlashCommandEvent event) {

        String invoke = event.getName();
        ICommand command = this.getCommand(invoke);

        if (command != null) {

            event.getChannel().sendTyping().queue();
            List<OptionMapping> args = event.getOptions();

            CommandContext context = new CommandContext(event, args);
            command.handle(context);

        }

    }

}
