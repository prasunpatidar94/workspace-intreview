package com.pp.sun.factory_method_pattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class NotificationWithSupplier {
    public static final Map<String, Supplier<Notification>> mapSupplier = new HashMap<>();

    static {
        mapSupplier.put("SMS", SmsNotification::new);
        mapSupplier.put("MAIL", MailNotification::new);
    }

    public static Notification createNotification(String typeNotification) throws IllegalAccessException {
        Supplier<Notification> ins = mapSupplier.get(typeNotification.toUpperCase());
        if (ins != null) return ins.get();
        throw new IllegalAccessException("Unknown Type passed ...");

    }

}
