package designpatterns.creational.factory.conceteCreator;

import designpatterns.creational.factory.concreteProduct.EmailNotification;
import designpatterns.creational.factory.creator.NotificationFactory;
import designpatterns.creational.factory.product.Notification;

public class EmailNotificationFactory implements NotificationFactory{ // Concrete Creator

    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
    
}
