package com.thread.lock;

import java.util.Random;

public class Consumer extends Thread {
    private Storage mStorage;
    private String mConsumer;
    private boolean isRunning = true;

    public Consumer(String consumer, Storage storage) {
        mConsumer = consumer;
        mStorage = storage;
    }

    @Override
    public void run() {
        while (isRunning) {
            mStorage.consume(mConsumer);
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
                isRunning = false;
            }
        }
    }
}
