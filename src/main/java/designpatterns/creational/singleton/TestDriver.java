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

class ConfigurationManagerMultithreadedEnhanced {

    /*Volatile on Config Manager makes sure of two things
    1. It prevents Instruction reordering (possible for java Compiler to enhance performance -- where instantiation, memory allocation and initialization steps could be reorganised and a thread could try 
    to access an incomplete instance of Config Manger) - Volatile Prevents this reordering 
    2. It makes sure that no thread caches the value of the variable and the latest value is always visible to all threads 
    What it does not make sure is - 

    1 It does not guarantee atomicity - It will not make sure that this variable is not accessed by two threads at the same time
    */
    private static volatile ConfigurationManagerMultithreadedEnhanced configurationManagerMultithreadedEnhanced;  
    private Map<String, String> config;

    //So no one can do any instantiation of ConfigurationManager
    private ConfigurationManagerMultithreadedEnhanced() { 
        loadConfig();
    }

    public static ConfigurationManagerMultithreadedEnhanced getConfigurationManagerMultithreadedEnhanced() {
        if(Objects.isNull(configurationManagerMultithreadedEnhanced)) {
            synchronized (ConfigurationManagerMultithreadedEnhanced.class) { // this here makes sure that two threads cannot simultaneously try to instantiate instance of Config Manager
                if(Objects.isNull(configurationManagerMultithreadedEnhanced)) {
                    configurationManagerMultithreadedEnhanced = new ConfigurationManagerMultithreadedEnhanced();
                }
            }
        } 
        return configurationManagerMultithreadedEnhanced;

    }

    public synchronized String getConfig(String key) { // making both set and get synchronized makes sure that one thread when trying to get .. will not allow another to set and vice versa
        return this.config.get(key);
    }

    public synchronized String setConfig(String key, String value) {
        return this.config.put(key, value);
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




