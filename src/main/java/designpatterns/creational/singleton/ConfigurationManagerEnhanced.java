package designpatterns.creational.singleton;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ConfigurationManagerEnhanced {

    private static ConfigurationManagerEnhanced configurationManagerEnhanced;
    private Map<String, String> config;

    //So no one can do any instantiation of ConfigurationManager
    private ConfigurationManagerEnhanced() { 
        loadConfig();
    }

    public static ConfigurationManagerEnhanced getConfigurationManagerEnhanced() {
        if(Objects.isNull(configurationManagerEnhanced)) {
            configurationManagerEnhanced = new ConfigurationManagerEnhanced();
        } 
        return configurationManagerEnhanced;

    }

    public String getConfig(String key) {
        return this.config.get(key);
    }

    private void loadConfig() {
        this.config = new HashMap<>();
        this.config.put("url", "someURL"+Math.random());
        this.config.put("apiKey", "someApiKey"+Math.random());
    }
}
