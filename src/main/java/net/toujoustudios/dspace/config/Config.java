package net.toujoustudios.dspace.config;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.HashMap;

/**
 * This file has been created by Ian Toujou.
 * Project: DSpace
 * Date: 06/08/2021
 * Time: 17:01
 */
public class Config {

    private HashMap<String, Object> content;
    private static final HashMap<String, Config> files = new HashMap<>();

    private String fileName;

    public Config(String fileName) {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
        content = yaml.load(inputStream);
        files.put(fileName, this);
    }

    public String getString(String key) {
        return (String) content.getOrDefault(key, null);
    }

    public boolean getBoolean(String key) {
        return (boolean) content.getOrDefault(key, false);
    }

    public int getInteger(String key) {
        return (int) content.getOrDefault(key, 0);
    }

    public double getDouble(String key) {
        return (double) content.getOrDefault(key, 0);
    }

    public float getFloat(String key) {
        return (float) content.getOrDefault(key, 0f);
    }

    public long getLong(String key) {
        return (long) content.getOrDefault(key, 0L);
    }

    public short getShort(String key) {
        return (short) content.getOrDefault(key, 0);
    }

    public Object getObject(String key) {
        return content.getOrDefault(key, 0);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public static Config getFile(String file) {
        return files.get(file);
    }

    public static Config getDefault() {
        return files.get("config.yml");
    }

    public static HashMap<String, Config> getFiles() {
        return files;
    }

    public HashMap<String, Object> getContent() {
        return content;
    }

    public void setContent(HashMap<String, Object> content) {
        this.content = content;
    }

}
