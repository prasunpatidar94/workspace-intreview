package com.pp.sun.factory_method_pattern;

public class FactoryNotification {

    public static Notification getNotification(String typeNotification) {
        return (typeNotification.equalsIgnoreCase("SMS")) ? new SmsNotification() : new MailNotification();
    }
}
