package com.thread.wait_notify;

import java.util.Random;

public class Consumer extends Thread {
    private Storage mStorage;
    private String mConsumer;

    public Consumer(String consumer, Storage storage) {
        mConsumer = consumer;
        mStorage = storage;
    }

    @Override
    public void run() {
        while (true){
            mStorage.consume(mConsumer);
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
