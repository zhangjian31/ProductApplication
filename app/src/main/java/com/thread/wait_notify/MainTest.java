package com.thread.wait_notify;


public class MainTest {

    public static void main(String args[]) throws InterruptedException {
        Storage storage = new Storage();

        new Producer("producer:" + "A", storage).start();
        new Consumer("consumer:" + "A", storage).start();

        new Producer("producer:" + "B", storage).start();
        new Consumer("consumer:" + "B", storage).start();

    }
}