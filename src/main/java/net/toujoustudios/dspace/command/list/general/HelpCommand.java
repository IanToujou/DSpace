package net.toujoustudios.dspace.command.list.general;

import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.toujoustudios.dspace.command.CommandCategory;
import net.toujoustudios.dspace.command.CommandContext;
import net.toujoustudios.dspace.command.ICommand;

import java.util.ArrayList;
import java.util.List;

/**
 * This file has been created by Ian Toujou.
 * Project: DSpace
 * Date: 11/08/2021
 * Time: 15:59
 */
public class HelpCommand implements ICommand {

    @Override
    public void handle(CommandContext context) {


    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Shows a list of all the bot commands.";
    }

    @Override
    public List<OptionData> getOptions() {

        List<OptionData> optionData = new ArrayList<>();
        optionData.add(new OptionData(OptionType.STRING, "command", "The command to get more information on.", false));
        return optionData;

    }

    @Override
    public CommandCategory getCategory() {
        return CommandCategory.GENERAL;
    }
}
