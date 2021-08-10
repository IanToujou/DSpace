package net.toujoustudios.dspace.main;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.toujoustudios.dspace.config.Config;
import net.toujoustudios.dspace.log.LogLevel;
import net.toujoustudios.dspace.log.Logger;
import org.yaml.snakeyaml.Yaml;

import javax.security.auth.login.LoginException;

/**
 * This file has been created by Ian Toujou.
 * Project: DSpace
 * Date: 03/08/2021
 * Time: 10:37
 */
public class DSpace {

    private JDABuilder builder;

    public void build() {

        Config config = Config.getDefault();

        builder = JDABuilder.createDefault(config.getString("keys.token"));

        builder.setBulkDeleteSplittingEnabled(false);
        builder.setActivity(Activity.streaming("/help - Running " + config.getString("general.name") + " " + config.getString("general.version"), "https://twitch.tv/iantoujou"));

        builder.enableIntents(GatewayIntent.GUILD_MEMBERS);
        builder.enableIntents(GatewayIntent.GUILD_PRESENCES);

    }

    public void start() {
        try {
            builder.build();
        } catch (LoginException exception) {
            exception.printStackTrace();
        }
    }

}
