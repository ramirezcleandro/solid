package notification.interfaces.impl;

import notification.interfaces.Notification;

public class EmailNotification implements Notification {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending Email notification.interfaces.Notification");
    }
}
