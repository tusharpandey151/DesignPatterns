package designpatterns.creational.singleton;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ConfigurationManagerMultithreadedEnhanced {

    /*Volatile on Config Manager makes sure of two things
    1. It prevents Instruction reordering (possible for java Compiler to enhance performance -- where  
     i - Memory allocation for the object.
     ii - Initialization of the object.     
      iii -  Assignment to instance. could be reorganised and a thread could try 
    to access an incomplete instance of Config Manger) - Volatile Prevents this reordering  - Makes sure it happens in same order

    2. It makes sure that no thread caches the value of the variable and the latest value is always visible to all threads -  
    
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
        System.out.println("Setting value " + value + " To Key " + key);
        return this.config.put(key, value);
    }

    private void loadConfig() {
        this.config = new HashMap<>();
        this.config.put("url", "someURL"+Math.random());
        this.config.put("apiKey", "someApiKey"+Math.random());
    }
}

class ConfigInitializer implements Runnable {

    Thread t;
    ConfigurationManagerMultithreadedEnhanced configurationManagerMultithreadedEnhanced;

    public ConfigInitializer(ConfigurationManagerMultithreadedEnhanced configurationManagerMultithreadedEnhanced, String name) {
        t = new Thread(this, name);
        this.configurationManagerMultithreadedEnhanced = configurationManagerMultithreadedEnhanced;
        t.start();
    }

    @Override
    public void run() {
        System.out.println(this.t.getName() + " Running");
        synchronized(this.configurationManagerMultithreadedEnhanced) { // a Syncronized block is necessary as the moment lock is left on configManager after setConfig, other thread pulls the lock on it
            this.configurationManagerMultithreadedEnhanced.setConfig("url", "updatedUrl "+(Math.random()*100));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(this.t.getName() + " " + this.configurationManagerMultithreadedEnhanced.getConfig("url"));
        }
        
        System.out.println(this.t.getName() + " Finished");
    }
}