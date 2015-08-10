package org.luyue.examples.java.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

import org.luyue.examples.java.concurrent.AtomicDemo.Sequencer;

public class AtomicDemo {

    public static void main(String[] args) {

        int numOfThreads = 5;
        // allows a set of threads to all wait for each other to reach a common barrier point to mimic concurrent
        // threads
        CyclicBarrier cBar = new CyclicBarrier(numOfThreads);

        NotThreadSafeSequencer notThreadSafeSequencer = new NotThreadSafeSequencer();
        for (int i = 0; i < numOfThreads; i++)
            new SequencerThread(notThreadSafeSequencer, cBar);

        SynchronizedSequencer synchronizedSequencer = new SynchronizedSequencer();
        for (int i = 0; i < numOfThreads; i++)
            new SequencerThread(synchronizedSequencer, cBar);

        ThreadSafeSequencer threadSafeSequencer = new ThreadSafeSequencer();
        for (int i = 0; i < numOfThreads; i++)
            new SequencerThread(threadSafeSequencer, cBar);
    }

    interface Sequencer {
        int getNext();
    }

    private static class NotThreadSafeSequencer implements Sequencer {

        private static int sequence = 0;

        @Override
        public int getNext() {
            // this operation is not atomic, which means that it does not execute as a single indivisible operation. It
            // is a sequence of three operations: fetch the current value, add one to it, and write the new value back
            return ++sequence;
        }
    }

    private static class SynchronizedSequencer implements Sequencer {

        private static int sequence = 0;

        @Override
        public synchronized int getNext() {
            // using locking to synchronize access to sequence
            return ++sequence;
        }
    }

    private static class ThreadSafeSequencer implements Sequencer {

        private static AtomicInteger sequence = new AtomicInteger(0);

        @Override
        public int getNext() {
            // atomically increments by one the current value and return the updated value
            return sequence.incrementAndGet();
        }
    }
}

class SequencerThread implements Runnable {

    private final Sequencer sequencer;
    private final CyclicBarrier cBar;

    SequencerThread(Sequencer sequencer, CyclicBarrier cBar) {
        this.sequencer = sequencer;
        this.cBar = cBar;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            // waiting for other threads to reach the barrier
            cBar.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("Next from " + sequencer.getClass().getSimpleName() + ": " + sequencer.getNext());
    }
}