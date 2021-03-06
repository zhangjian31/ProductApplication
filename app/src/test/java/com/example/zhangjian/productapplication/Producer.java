package com.example.zhangjian.productapplication;

import com.thread.wait_notify.Storage;

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
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
