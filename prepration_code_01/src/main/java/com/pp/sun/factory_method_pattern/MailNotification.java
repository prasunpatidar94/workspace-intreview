package com.pp.sun.factory_method_pattern;

public class MailNotification implements Notification{

    @Override
    public void userNotification() {
        System.out.println("Mail Notification");
    }
}
