package com.pp.sun.MultithreadingConcurrency;

public class ThreadCreationMethods {
    public static void main(String[] args) throws InterruptedException {

       /*TODO Thread life cycle: NEW -> RUNNABLE ->Running -> Waiting/Blocked -> Termination
           NEW : Thread created  but not ready to start
           RUNNABLE : creation done ready to start or run  it will  run by JVM when it has capacity  to run that thread.
           RUNNING: it is started and working on task .
           WAITING Or BLOCKED: in this it will wait for another dependent thread to completed it's task abd use it's output as input to it's execution
           OR Blacked due to resource  are not available  or andy error.
           TERMINATION: in this Thread will stopped once it's work done , or forcefully terminated  due to some specific condition.
       */

//TODO        #01
        Thread classExtentedThread = new MyThreadWithExtend(); //TODO NEW STATE
        System.out.println(classExtentedThread.getState());
        // bad approche because run () run inside the mail  it will not created new thread
//        classExtentedThread.run();
        // it is best way to run  any thread because it will create  the new thread in JVM  sepeted from main thread
        classExtentedThread.start(); // TODO RUNNABLE STATE
        System.out.println(classExtentedThread.getState());
        classExtentedThread.join(); // TODO TERMINATED STATUS (once finish child tsk and the terminate then mail will execute and terminate)
        System.out.println(classExtentedThread.getState());


//TODO        #02
        Runnable threadWithRunnable = ()->{
            System.out.println("My Api is call with Runnable thread ...!");
        };
        //as we know run method call is nott good approch to start thread
        //but hear Runnable is an functional interface  and there  is only one abs method run()
        threadWithRunnable.run();
        // so we have to assigne it in Thread class beccause it has  run() and start() methods impl .
        Thread runnableinsideThread = new Thread(threadWithRunnable,"runnable thread");
        runnableinsideThread.start();

        // in above to approched we have 2 big limitation :
        // 1st : no return value
        // 2 nd : No checked exception (means  we can not put check exception in side it )
        // solution to overcome thid issue we have another approch where we can cerate theread and get return valsue and apply the checked exception..
//TODO        #03 (solution Callable + future with executor services API )





    }
}


//Approche #01 to create thread
class MyThreadWithExtend extends Thread{
    /*TODO
       Thread extend will work only when  current class is not extending  another class
       but if  current class is extending another class then we have to use implementation of Runnable interface style
       because java not support multiple inheritance  with extend keyword
     */
    @Override
    public void run() {
        System.out.println("RUNNING");
        try {
            Thread.sleep(1000L);    //TODO WAITING_TIMEOUT STATE
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("My api Call with class extended thread ..! ");
    }
}