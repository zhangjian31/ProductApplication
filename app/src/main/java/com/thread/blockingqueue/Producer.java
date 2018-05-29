package com.thread.blockingqueue;

import java.util.Random;

public class Producer extends Thread {
    private Storage mStorage;
    private String mProducer;

    public Producer(String producer, Storage storage) {
        mProducer = producer;
        mStorage = storage;
    }

    @Override
    public void run() {
        while (true) {
            mStorage.produce(mProducer);
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
