package designpatterns.creational.singleton;

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

        ConfigurationManagerMultithreadedEnhanced configurationManagerMultithreadedEnhanced1 = ConfigurationManagerMultithreadedEnhanced.getConfigurationManagerMultithreadedEnhanced();
        new ConfigInitializer(configurationManagerMultithreadedEnhanced1, "Thread 1");
        ConfigurationManagerMultithreadedEnhanced configurationManagerMultithreadedEnhanced2 = ConfigurationManagerMultithreadedEnhanced.getConfigurationManagerMultithreadedEnhanced();
        new ConfigInitializer(configurationManagerMultithreadedEnhanced2, "Thread 2");


        System.out.println(configurationManagerEnhanced1.getConfig("url"));
        System.out.println(configurationManagerEnhanced2.getConfig("url"));
        System.out.println(configurationManagerEnhanced2.getConfig("apiKey"));
        System.out.println(configurationManagerEnhanced1.getConfig("apiKey"));
        
    }
}




