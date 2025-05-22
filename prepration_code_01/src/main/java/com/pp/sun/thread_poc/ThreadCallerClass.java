package com.pp.sun.thread_poc;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadCallerClass {
    public static void main(String[] args) {

        // START Thread Class- simple way to create Thread with extends Thread Class
        /*Thread thread1=new Thread(new ThreadCreationWithExtendsThreadClass("Task-1"));
        Thread thread2=new Thread(new ThreadCreationWithExtendsThreadClass("Task-2"));
        Thread thread3=new Thread(new ThreadCreationWithExtendsThreadClass("Task-3"));
        Thread thread4=new Thread(new ThreadCreationWithExtendsThreadClass("Task-4"));

        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println("Prasun");
        thread4.start();*/
        // END Thread Class- ============================================

        //START Runnable Interface with implimentation and lemada expression
        /*Thread runableThread1=new Thread(new ThreadCreationWithImplimentRunnableInterface("Tunable Thread-1"));
        Thread runableThread2=new Thread(new ThreadCreationWithImplimentRunnableInterface("Tunable Thread-2"));
        Thread runableThread3=new Thread(new ThreadCreationWithImplimentRunnableInterface("Tunable Thread-3"));
        Thread runableThread4=new Thread(new ThreadCreationWithImplimentRunnableInterface("Tunable Thread-4"));
        runableThread1.start();
        runableThread2.start();
        runableThread3.start();
        runableThread4.start();
        Runnable runnableWithLemada= ()-> System.out.println("Runnable with Lamada Expression - 1");
        new Thread(runnableWithLemada).start();*/
//      END runnable Intraface =====================================

//      START Executor Single Creation

        ExecutorService executorService= Executors.newSingleThreadExecutor();
        executorService.submit(()-> System.out.println("task with Executors Services Class -1"));
        ex
        executorService.shutdown();
//      END Executor Single Creation===================================================




    }
}
