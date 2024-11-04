package designpatterns.creational.factory;

import designpatterns.creational.factory.creator.NotificationFactory;

public class NotificationServiceFactoryPattern {

    NotificationFactory notificationFactory;

    public NotificationServiceFactoryPattern(NotificationFactory notificationFactory) {
        this.notificationFactory = notificationFactory;
    }

    public void sendNotification(String message, String receiver) {
        notificationFactory.createNotification().sendNotification(message, receiver);
    }
    
}
