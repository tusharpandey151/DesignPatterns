package designpatterns.creational.factory;

import designpatterns.creational.factory.conceteCreator.EmailNotificationFactory;
import designpatterns.creational.factory.conceteCreator.PushNotificationFactory;
import designpatterns.creational.factory.conceteCreator.SMSNotificationFactory;

public class TestDriver {
    public static void main(String args[]) {
        //Normal Notification without Factory Pattern

        /*
         * Tight Coupling - New Type of Notification would result in change on NotificationServiceLayman to add new if block 
         * Too many if else
         * 
         */

        NotificationServiceLayman notificationService = new NotificationServiceLayman(); 
        notificationService.sendNotification("EMAIL",null, null);
        notificationService.sendNotification("SMS", null, null);
        notificationService.sendNotification("PUSH", null, null);


        // With Factory Pattern
        /*
         *         Here keep adding new types of Notifications in product and relevant Concrete Products and Concrete Creators -- 
         * By adding these new Concrete Products and Concrete Creators we are following the open for extension and closed for change prinicpal - we are extending products and creators
         * Also since each Factory has only one work - Single Reason to Exist following S in SOLID 
         */


        NotificationServiceFactoryPattern emailNotificationFactory = new NotificationServiceFactoryPattern(new EmailNotificationFactory());
        NotificationServiceFactoryPattern smsNotificationFactory = new NotificationServiceFactoryPattern(new SMSNotificationFactory());
        NotificationServiceFactoryPattern pushNotificationFactory = new NotificationServiceFactoryPattern(new PushNotificationFactory());

        emailNotificationFactory.sendNotification("Email Message Sent", "xyz@gmail.com");
        smsNotificationFactory.sendNotification("SMS Message", "00000000");
        pushNotificationFactory.sendNotification("Push Notification", "DeviceID");

        // Another way without having a new Factory being Passed
        /*
         * Another way is to store the instances of Factory against an ENUM (So we pass an enum.getNotificationFactory 
         * or MAP so we call get("Keyword for Factory Type")
         * or in a provider / Factory Provider class where based on some Type keyword passed here .. we get back the factory Object
         */
        
        NotificationServiceFactoryPattern emailNotificationFactory1 = new NotificationServiceFactoryPattern(NotificationServiceTypesEnum.EMAIL.getNotificationFactory());
        NotificationServiceFactoryPattern smsNotificationFactory2 = new NotificationServiceFactoryPattern(NotificationServiceTypesEnum.SMS.getNotificationFactory());
        NotificationServiceFactoryPattern pushNotificationFactory3 = new NotificationServiceFactoryPattern(NotificationServiceTypesEnum.PUSH.getNotificationFactory());

        emailNotificationFactory1.sendNotification("Email Message Sent With Enum", "xyz@gmail.com");
        smsNotificationFactory2.sendNotification("SMS Message with Enum", "00000000");
        pushNotificationFactory3.sendNotification("Push Notification with Enum", "DeviceID");
        
    }
}
