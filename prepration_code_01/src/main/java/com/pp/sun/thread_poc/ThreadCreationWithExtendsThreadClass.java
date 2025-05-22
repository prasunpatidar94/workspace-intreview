package com.pp.sun.thread_poc;

public class ThreadCreationWithExtendsThreadClass extends Thread{

    private  String threadName;

    public ThreadCreationWithExtendsThreadClass(String threadName){
        this.threadName=threadName;
    }
    public void run(){
        System.out.println("start running thread "+threadName+"..!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
