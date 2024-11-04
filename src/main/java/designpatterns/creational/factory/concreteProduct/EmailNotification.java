package designpatterns.creational.factory.concreteProduct;

import designpatterns.creational.factory.product.Notification;

public class EmailNotification implements Notification{ // Concrete Product

    @Override
    public void sendNotification(String message, String receiver) {
        System.out.println("Sending Email to " + receiver + " with message as : " + message);
    }
    
}
