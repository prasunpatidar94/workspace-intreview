package com.pp.sun.MultithreadingConcurrency;

public class ThreadClassMethods {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main Thread started ...!");
        MySleepyThread mySleepyThread = new MySleepyThread("Sleepy");
        mySleepyThread.start();// TODO To start() method  thread and push run method for JVM to be execute...!
        mySleepyThread.interrupt(); // TODO interrupt() it  can disturb any of the thread in between the task execution.
        mySleepyThread.join(); //TODO join() method help us to say main thread or parent  thread to wait for the child thread to be complete then you can terminate yourself

        System.out.println("Priority methods ...!");

        MySleepyThread mySleepyThreadL = new MySleepyThread("LOW");
        MySleepyThread mySleepyThreadM = new MySleepyThread("MEDIUM");
        MySleepyThread mySleepyThreadH = new MySleepyThread("HIGH");

        // TODO Here setPriority() method help us to give Priority execution index that help us to execute our thread to be according to required priority.
        mySleepyThreadL.setPriority(Thread.MIN_PRIORITY);
        mySleepyThreadM.setPriority(Thread.NORM_PRIORITY);
        mySleepyThreadH.setPriority(Thread.MAX_PRIORITY);

//        mySleepyThreadL.start();
//        mySleepyThreadM.start();
//        mySleepyThreadH.start();

        System.out.println("Yeld Method ..!");
        MyGivenChanceThread myGivenChanceThread = new MyGivenChanceThread("Yeld");
        myGivenChanceThread.start();

        mySleepyThreadL.start();
        mySleepyThreadM.start();
        mySleepyThreadH.start();


        System.out.println("serDemon() method  ...!");

        DemonThreadNotDemanedJVMToBeWaitTillItIsRunning demon = new DemonThreadNotDemanedJVMToBeWaitTillItIsRunning("DEMON ") ;
        /* TODO setDemon( ) this is allow there to  run in background  and running continuously
            till main thread is live and running demon thread will terminate in any point of  time
            long with main thread  finishes */
        demon.setDaemon(true);
        demon.start();
        System.out.println("Main thread completed ...!");





    }
}


class MySleepyThread extends Thread {

    MySleepyThread(String name) {
        super(name);
    }

    @Override
    public void run() { // TODO run method which will responsible to  run business logic a ot tark
        System.out.println(currentThread().getName() + "I am Sleepy Thread  currently i am sleeping ....!");
        try {
            Thread.sleep(2000L); // TODO sleep() method  help us to make thread stop execution for some time but not come out for scheduled status
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(currentThread().getName() + "I am Sleepy Thread  currently i am weakening  ....!");
    }
}

class MyGivenChanceThread extends Thread {

    MyGivenChanceThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("My Yeld Thread Starts ... !"+ currentThread().getName());
        for (int i = 0; i < 10; i++) {
            System.out.println("I am yeld Thread : " + currentThread().getName() + " :- " + i);
            Thread.yield(); // TODO yield() give chance to run other thread at the time or running State..
        }
        System.out.println("My Yeld Thread completed  ... !"+ currentThread().getName());

    }
}

class DemonThreadNotDemanedJVMToBeWaitTillItIsRunning extends Thread{

    DemonThreadNotDemanedJVMToBeWaitTillItIsRunning(String name){
        super(name);
    }
    @Override
    public void run() {
        System.out.println("I am :"+currentThread().getName()+" : - Start  "  );
        int i = 0;
        while (true){
            System.out.println("I AM "+currentThread().getName()+" Running : - "+i++);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
