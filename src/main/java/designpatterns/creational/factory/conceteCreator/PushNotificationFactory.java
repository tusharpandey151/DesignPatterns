package designpatterns.creational.factory.conceteCreator;

import designpatterns.creational.factory.concreteProduct.PushNotification;
import designpatterns.creational.factory.creator.NotificationFactory;
import designpatterns.creational.factory.product.Notification;

public class PushNotificationFactory implements NotificationFactory{ // Concrete Creator


    @Override
    public Notification createNotification() {
        return new PushNotification();
    }
    
}
