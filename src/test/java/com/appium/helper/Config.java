package com.appium.helper;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.util.Map;

public class Config {

    private static Config instance = null;
    private Map loadYml = null;

    private Config() {
        load_yaml_file();
    }

    // static method to create instance of Singleton class
    public static Config Instance() {
        if (instance == null)
            instance = new Config();

        return instance;
    }

    public String getJavaHome() { return loadYml.get("java_home").toString(); }

    public String getXCodePath() {
        return loadYml.get("xcode_path").toString();
    }

    public String getApplication() { return loadYml.get("application").toString(); }

    public String getDeviceName() {
        return loadYml.get("device_name").toString();
    }

    public String getUrl() { return loadYml.get("url").toString();}

    public String getUser() { return loadYml.get("user").toString();}

    public String getPassword() { return loadYml.get("password").toString();}

    private void load_yaml_file() {
        try {
            if (loadYml == null) {
                String file_path = Project.ROOT + "/src/test/resources/config/config.yml";
                loadYml = (Map) new Yaml().load(new FileInputStream(file_path));
            }
        } catch (Exception e) {
        }
    }
}
