package designpatterns.creational.factory;

public class NotificationServiceLayman {
    public void sendNotification(String type, String receiver, String message) {
        if(type.equals("EMAIL")) {
            sendEmail(receiver, message);
        }
        else if (type.equals("SMS")) {
            sendSMS(receiver, message);
        }
        else if (type.equals("PUSH")) {
            sendPUSH(receiver, message);
        }
    }

    private void sendEmail(String receiver, String message) {
        System.out.println("Sending an Email Notification without Factory Pattern");
    }

    private void sendSMS(String receiver, String message) {
        System.out.println("Sending a SMS Notification without Factory Pattern");
    }

    private void sendPUSH(String receiver, String message) {
        System.out.println("Sending a PUSH Notification without Factory Pattern");
    }
}
