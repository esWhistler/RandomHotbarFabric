package com.whistler.randhotbar.config;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class ConfigFile {
    protected File configFile;

    public ConfigFile(String path){
        configFile = new File(path);
    }

    public void write(Properties properties, String comment) throws IOException {
        FileWriter writer = new FileWriter(this.configFile);
        properties.store(writer, comment);

        writer.close();
    }

    public String read(String propertyName) throws IOException {
        FileReader reader = new FileReader(this.configFile);
        Properties props = new Properties();
        props.load(reader);

        String getProperty = props.getProperty(propertyName);

        reader.close();

        return getProperty;
    }
}
