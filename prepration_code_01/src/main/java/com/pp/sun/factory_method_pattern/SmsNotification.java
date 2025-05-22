package com.pp.sun.factory_method_pattern;

public class SmsNotification implements Notification{

    @Override
    public void userNotification() {
        System.out.println("SMS Notification");
    }
}
