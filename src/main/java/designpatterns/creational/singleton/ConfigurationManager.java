package designpatterns.creational.singleton;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationManager {

    Map<String, String> config;

    public ConfigurationManager() {
        loadConfig();
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