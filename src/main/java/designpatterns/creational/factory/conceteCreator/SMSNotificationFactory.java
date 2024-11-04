package designpatterns.creational.factory.conceteCreator;

import designpatterns.creational.factory.concreteProduct.SMSNotification;
import designpatterns.creational.factory.creator.NotificationFactory;
import designpatterns.creational.factory.product.Notification;

public class SMSNotificationFactory implements NotificationFactory { // Concrete Creator

    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
    
}
