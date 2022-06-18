package com.whistler.randhotbar.config;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class ConfigFile {
    public static File configFile;

    public static void create(String pathname, Properties properties, String comment) throws IOException {
        configFile = new File(pathname);
        if (!configFile.exists()) {
            FileWriter writer = new FileWriter(configFile);
            properties.store(writer, comment);

            writer.close();
        }
    }

    public static void update(Properties properties, String comment) throws IOException {
        FileWriter writer = new FileWriter(configFile);
        properties.store(writer, comment);

        writer.close();
    }

    public static String read(String propertyName) throws IOException {
        FileReader reader = new FileReader(configFile);
        Properties props = new Properties();
        props.load(reader);

        String getProperty = props.getProperty(propertyName);

        reader.close();

        return getProperty;
    }
}
