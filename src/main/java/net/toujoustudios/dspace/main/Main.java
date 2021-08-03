package net.toujoustudios.dspace.main;

import net.toujoustudios.dspace.loader.Loader;

/**
 * This file has been created by Ian Toujou.
 * Project: DSpace
 * Date: 01/08/2021
 * Time: 17:14
 */
public class Main {

    private static DSpace bot;

    public static void main(String[] args) {
        bot = new DSpace();
        Loader.startLoading();
    }

    public static DSpace getBot() {
        return bot;
    }
}
