package designpatterns.creational.factory;

import designpatterns.creational.factory.conceteCreator.EmailNotificationFactory;
import designpatterns.creational.factory.conceteCreator.PushNotificationFactory;
import designpatterns.creational.factory.conceteCreator.SMSNotificationFactory;
import designpatterns.creational.factory.creator.NotificationFactory;

public enum NotificationServiceTypesEnum {

    SMS(new SMSNotificationFactory()),
    EMAIL(new EmailNotificationFactory()),
    PUSH(new PushNotificationFactory());

    NotificationFactory notificationFactory; 
    
        NotificationServiceTypesEnum(NotificationFactory notificationFactory) {
            this.notificationFactory = notificationFactory;
        }

        public NotificationFactory getNotificationFactory() {
            return notificationFactory;
        }

    
}
