package com.pp.sun.thread_poc;

public class ThreadCreationWithImplimentRunnableInterface implements Runnable{

    private  String threadName;

    public ThreadCreationWithImplimentRunnableInterface(String threadName){
        this.threadName=threadName;
    }
    @Override
    public void run(){
        System.out.println("start running thread "+threadName+"..!");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
