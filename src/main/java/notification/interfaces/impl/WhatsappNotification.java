package notification.interfaces.impl;

import notification.interfaces.Notification;

public class WhatsappNotification implements Notification {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending Whatssap notification.interfaces.Notification");
    }
}
