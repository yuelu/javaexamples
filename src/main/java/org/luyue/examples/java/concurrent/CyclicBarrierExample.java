package org.luyue.examples.java.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * <pre>
 * When a set of threads must wait at a certain execution point until all threads in the set have reached that point.
 * 1). create a CyclicBarrier instance and specify the number of threads that will be waiting for
 * 2). each thread reaches the barrier, have it call await() on that object. This will pause execution of the thread
 *     until all of the other threads also called await()
 * 3). once the specified number of threads has reached the barrier, await() will return and execution will resume
 * 
 * </pre>
 * 
 * @author jlu
 *
 */
public class CyclicBarrierExample {

    public static void main(String[] args) {

        int numOfThreads = 3;
        CyclicBarrier cBar = new CyclicBarrier(numOfThreads, new Runnable() {

            @Override
            public void run() {
                // this line will be printed out once numOfThreads called await()
                System.out.println("yeah! Barrier reached! ");
            }
        });

        for (int i = 0; i < numOfThreads; i++)
            new SayHiThread("Thread " + i, cBar);
    }
}

class SayHiThread implements Runnable {

    private final String name;
    private final CyclicBarrier cBar;

    SayHiThread(String name, CyclicBarrier cBar) {
        this.name = name;
        this.cBar = cBar;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println(name + " enter run()...");
        try {
            // waiting for other threads to reach the barrier
            cBar.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        // resumes after all threads reach the barrier
        System.out.println("Hi from [" + name + "]");
    }

}
