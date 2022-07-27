package com.whistler.randhotbar.config;

import java.io.*;
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

    public String read(String propertyName, String defaultValue) throws IOException {
        Properties props = this.getProperties();

        return props.getProperty(propertyName, defaultValue);
    }

    public Properties getProperties() throws IOException {
        FileReader reader = new FileReader(this.configFile);
        Properties props = new Properties();
        props.load(reader);
        reader.close();

        return props;
    }
}
