package net.toujoustudios.dspace.loader;

import net.toujoustudios.dspace.main.Main;

/**
 * This file has been created by Ian Toujou.
 * Project: DSpace
 * Date: 03/08/2021
 * Time: 10:53
 */
public class Loader {

    private static LoaderState state;

    public static void startLoading() {

        preInitialize();
        initialize();
        postInitialize();

    }

    private static void preInitialize() {}

    private static void initialize() {
        Main.getBot().build();
    }

    private static void postInitialize() {
        Main.getBot().start();
    }

    public static LoaderState getState() {
        return state;
    }

    public static void setState(LoaderState state) {
        Loader.state = state;
    }

    public static void cancel() {
        Loader.state = LoaderState.CANCELLED;
    }

}
