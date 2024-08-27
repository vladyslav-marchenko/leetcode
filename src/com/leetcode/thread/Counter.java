package com.leetcode.thread;

import java.util.concurrent.Semaphore;

public class Counter {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                increment();
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        System.out.println(counter);
    }

    private static Integer counter = 0;
    private static final Semaphore semaphore = new Semaphore(1);

    private static /*synchronized*/ void increment() {
        try {
            semaphore.acquire();
            counter++;
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
