package designpatterns.creational.factory.concreteProduct;

import designpatterns.creational.factory.product.Notification;

public class PushNotification implements Notification{ // Concrete Product

    @Override
    public void sendNotification(String message, String receiver) {
        System.out.println("Sending a PUSH Notification to " + receiver + " with message as : " + message);
    }

    
    
}
