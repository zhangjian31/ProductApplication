package com.thread.lock;

import java.util.Random;

public class Producer extends Thread {
    private Storage mStorage;
    private String mProducer;
    private boolean isRunning = true;

    public Producer(String producer, Storage storage) {
        mProducer = producer;
        mStorage = storage;
    }

    @Override
    public void run() {
        while (isRunning) {
            mStorage.produce(mProducer);
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
                isRunning = false;
            }
        }
    }
}
