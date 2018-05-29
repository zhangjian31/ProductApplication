package com.thread.blockingqueue;

import java.util.LinkedList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Storage {

    private final int MAX_SIZE = 2;
    private LinkedBlockingDeque<Object> list = new LinkedBlockingDeque<>();

    public void produce(String producer) {
        if (list.size() == MAX_SIZE) {
            System.out.println("仓库满【" + producer + "】不能生产");
        }
        try {
            list.put(new Object());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("【" + producer + "】生产了一个产品");
    }

    public void consume(String consume) {
        if (list.size() == 0) {
            System.out.println("仓库已空【" + consume + "】不能消费");
        }
        try {
            list.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("【" + consume + "】消费了一个产品");
    }
}
