package net.toujoustudios.dspace.listener;

import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.toujoustudios.dspace.main.Main;
import org.jetbrains.annotations.NotNull;

/**
 * This file has been created by Ian Toujou.
 * Project: DSpace
 * Date: 09/08/2021
 * Time: 12:55
 */
public class SlashCommandListener extends ListenerAdapter {

    @Override
    public void onSlashCommand(@NotNull SlashCommandEvent event) {

        if (event.getGuild() == null) return;
        if (event.getUser().isBot()) return;

        Main.getBot().getCommandManager().handle(event);

    }

}
