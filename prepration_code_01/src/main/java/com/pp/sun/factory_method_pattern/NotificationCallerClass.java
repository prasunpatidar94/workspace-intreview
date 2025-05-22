package com.pp.sun.factory_method_pattern;

public class NotificationCallerClass {
    public static void main(String[] args) throws IllegalAccessException {
//        #01 Classical Example of the Factory pattern
        FactoryNotification.getNotification("sms").userNotification();
        FactoryNotification.getNotification("sm").userNotification();
//        #02 Java 8 with Supplier
        NotificationWithSupplier.createNotification("Sms").userNotification();
        NotificationWithSupplier.createNotification("Mail").userNotification();

    }
}
