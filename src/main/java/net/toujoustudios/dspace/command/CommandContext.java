package net.toujoustudios.dspace.command;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.util.List;

/**
 * This file has been created by Ian Toujou.
 * Project: DSpace
 * Date: 11/08/2021
 * Time: 14:49
 */
public class CommandContext implements ICommandContext {

    private final SlashCommandEvent event;
    private final List<OptionMapping> args;

    public CommandContext(SlashCommandEvent event, List<OptionMapping> args) {
        this.event = event;
        this.args = args;
    }

    @Override
    public Guild getGuild() {
        return this.getEvent().getGuild();
    }

    @Override
    public SlashCommandEvent getEvent() {
        return this.event;
    }

    public List<OptionMapping> getArgs() {
        return this.args;
    }

}
