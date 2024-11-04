package designpatterns.creational.factory.creator;

import designpatterns.creational.factory.product.Notification;

public interface NotificationFactory { // creator
    Notification createNotification();
}
