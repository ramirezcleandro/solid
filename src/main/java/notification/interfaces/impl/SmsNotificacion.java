package notification.interfaces.impl;

import notification.interfaces.Notification;

public class SmsNotificacion implements Notification {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS notification.interfaces.Notification");
    }
}
