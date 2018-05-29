package com.thread.lock;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Storage {

    private final int MAX_SIZE = 2;
    private LinkedList<Object> list = new LinkedList<>();
    private Lock lock = new ReentrantLock();
    private Condition fullCondition = lock.newCondition();
    private Condition emptyCondition = lock.newCondition();

    public void produce(String producer) {
        lock.lock();
        try {
            while (list.size() == MAX_SIZE) {
                System.out.println("仓库满【" + producer + "】不能生产");
                fullCondition.await();
            }
            list.add(new Object());
            System.out.println("【" + producer + "】生产了一个产品");
            emptyCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consume(String consume) {
        try {
            lock.lock();
            while (list.size() == 0) {
                System.out.println("仓库已空【" + consume + "】不能消费");
                emptyCondition.await();
            }
            list.remove();
            System.out.println("【" + consume + "】消费了一个产品");
            fullCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public LinkedList<Object> getList() {
        return list;
    }

    public void setList(LinkedList<Object> list) {
        this.list = list;
    }

    public int getMaxSize() {
        return MAX_SIZE;
    }
}
