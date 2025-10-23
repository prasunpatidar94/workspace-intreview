//package com.pp.sun.own_pub_sub_tool;
//
//
//import org.apache.logging.log4j.message.Message;
//
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.CopyOnWriteArrayList;
//import java.util.concurrent.Flow;
//
//class PubSubBroker {
//    // Topic → List of subscribers
//    private final Map<String, CopyOnWriteArrayList<Flow.Subscriber>> subscribers = new ConcurrentHashMap<>();
//
//    // Subscribe
//    public void subscribe(String topic, Flow.Subscriber subscriber) {
//        subscribers.computeIfAbsent(topic, k -> new CopyOnWriteArrayList<>()).add(subscriber);
//    }
//
//    // Unsubscribe
//    public void unsubscribe(String topic, Flow.Subscriber subscriber) {
//        subscribers.getOrDefault(topic, new CopyOnWriteArrayList<>()).remove(subscriber);
//    }
//
//    // Publish
//    public void publish(Message message) {
//        List<Flow.Subscriber> subs = subscribers.getOrDefault(message.getTopic(), new CopyOnWriteArrayList<>());
//        for (Flow.Subscriber s : subs) {
//            CompletableFuture.runAsync(() -> s.onMessage(message)); // async delivery
//        }
//    }
//}
