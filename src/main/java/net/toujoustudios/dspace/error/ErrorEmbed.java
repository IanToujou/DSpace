package net.toujoustudios.dspace.error;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.toujoustudios.dspace.color.ColorTools;
import net.toujoustudios.dspace.config.Config;

/**
 * This file has been created by Ian Toujou.
 * Project: DSpace
 * Date: 26/08/2021
 * Time: 23:12
 */
public class ErrorEmbed {

    static Config config = Config.getDefault();

    public static MessageEmbed buildError(ErrorType type) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle(":x: **Something went wrong**");
        embedBuilder.setColor(ColorTools.getFromRGBString(config.getString("format.color.error")));
        embedBuilder.setThumbnail(config.getString("assets.icon.error"));
        embedBuilder.setDescription("Oops! An error occurred while attempting to perform this action. Please review the details below.\n\n**Error Code:** `" + type.getCode() + "`\n**Description:** " + type.getDescription());
        return embedBuilder.build();
    }

}
