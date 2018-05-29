package com.example.zhangjian.productapplication;

import com.thread.wait_notify.Storage;

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
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
