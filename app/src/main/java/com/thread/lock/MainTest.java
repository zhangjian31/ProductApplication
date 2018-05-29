package com.thread.lock;


public class MainTest {

    public static void main(String args[]) throws InterruptedException {
        Storage storage = new Storage();

        Producer producerA = new Producer("producer:" + "A", storage);
        producerA.start();
        Consumer consumerA = new Consumer("consumer:" + "A", storage);
        consumerA.start();

        Producer producerB = new Producer("producer:" + "B", storage);
        producerB.start();
        Consumer consumerB = new Consumer("consumer:" + "B", storage);
        consumerB.start();

        Thread.sleep(5000);
        producerA.interrupt();
        Thread.sleep(2000);
        producerB.interrupt();

    }
}