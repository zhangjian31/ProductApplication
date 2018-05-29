package com.example.zhangjian.productapplication;

import com.thread.wait_notify.Consumer;
import com.thread.wait_notify.Producer;
import com.thread.wait_notify.Storage;

import org.junit.Test;


public class ExampleUnitTest {
    @Test
    public void test1() {
        Storage storage = new Storage();
        for (int i = 0; i < 1; i++) {
            Producer producer = new Producer("producer:" + i, storage);
            Consumer consumer = new Consumer("consumer:" + i, storage);
            producer.start();
            consumer.start();
        }
    }

    public static void main(String args[]) {
        Storage storage = new Storage();
        for (int i = 0; i < 1; i++) {
            Producer producer = new Producer("producer:" + i, storage);
            Consumer consumer = new Consumer("consumer:" + i, storage);
            producer.start();
            consumer.start();
        }
    }
}