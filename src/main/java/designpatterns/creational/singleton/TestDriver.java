package designpatterns.creational.singleton;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TestDriver {

    public static void main(String args[]) {
        ConfigurationManager configurationManager1 = new ConfigurationManager();
        ConfigurationManager configurationManager2 = new ConfigurationManager();

        System.out.println(configurationManager1.getConfig("url"));
        System.out.println(configurationManager2.getConfig("url"));
        System.out.println(configurationManager2.getConfig("apiKey"));
        System.out.println(configurationManager1.getConfig("apiKey"));

        ConfigurationManagerEnhanced configurationManagerEnhanced1 = ConfigurationManagerEnhanced.getConfigurationManagerEnhanced();//This makes sure we always get the one and only one instance of configuration manager as evident from same number post api key and url in this case
        ConfigurationManagerEnhanced configurationManagerEnhanced2 = ConfigurationManagerEnhanced.getConfigurationManagerEnhanced();
        System.out.println(configurationManagerEnhanced1.getConfig("url"));
        System.out.println(configurationManagerEnhanced2.getConfig("url"));
        System.out.println(configurationManagerEnhanced2.getConfig("apiKey"));
        System.out.println(configurationManagerEnhanced1.getConfig("apiKey"));
        
    }
}

class ConfigurationManagerEnhanced {

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




class ConfigurationManager {

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




