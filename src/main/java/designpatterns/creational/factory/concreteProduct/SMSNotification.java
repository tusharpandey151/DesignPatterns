package designpatterns.creational.factory.concreteProduct;

import designpatterns.creational.factory.product.Notification;

public class SMSNotification implements Notification{ // Concrete Product

    @Override
    public void sendNotification(String message, String receiver) {
        System.out.println("Sending a SMS to " + receiver + " with message as : " + message);
    }
    
}
