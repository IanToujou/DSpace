package net.toujoustudios.dspace.config;

import net.toujoustudios.dspace.log.LogLevel;
import net.toujoustudios.dspace.log.Logger;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.HashMap;

/**
 * This file has been created by Ian Toujou.
 * Project: DSpace
 * Date: 06/08/2021
 * Time: 17:01
 */
public class Config {

    private static final HashMap<String, Config> files = new HashMap<>();
    private HashMap<String, Object> content;

    public Config(String filename) {

        try {
            InputStream inputStream = new FileInputStream("src/main/resources/" + filename);
            Yaml yaml = new Yaml();
            content = yaml.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        files.put(filename, this);
        Logger.log(LogLevel.INFORMATION, "Configuration file " + filename + " loaded.");

    }

    public void printContent() {
        for(String name : content.keySet()) {
            String value = content.get(name).toString();
            System.out.println(name + " => " + value);
        }
    }

    public String getString(String key) {
        return (String) content.getOrDefault(key, null);
    }

    public int getInteger(String key) { return (int) content.getOrDefault(key, 0); }

    private static HashMap<String, Object> readFile(String filename) {

        HashMap<String, Object> map = new HashMap<>();

        try {

            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/" + filename));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] content = line.split(": ");
                if(content.length == 2) {
                    String key = content[0];
                    String value = content[1].replaceAll("\"", "");
                    map.put(key, value);
                }
            }

        } catch(IOException exception) {
            exception.printStackTrace();
        }

        return map;

    }

    public static Config getFile(String filename) {
        return files.getOrDefault(filename, null);
    }

    public static Config getDefault() {
        return getFile("config.yml");
    }

}
