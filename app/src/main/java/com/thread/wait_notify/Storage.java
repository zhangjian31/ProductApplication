package com.thread.wait_notify;

import java.util.LinkedList;

public class Storage {

    private final int MAX_SIZE = 2;
    private LinkedList<Object> list = new LinkedList<>();

    public void produce(String producer) {
        synchronized (list) {
            while (list.size() == MAX_SIZE) {
                System.out.println("仓库满【" + producer + "】不能生产");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(new Object());
            System.out.println("【" + producer + "】生产了一个产品");
            list.notifyAll();
        }
    }

    public void consume(String consume) {
        synchronized (list) {
            while (list.size() == 0) {
                System.out.println("仓库已空【" + consume + "】不能消费");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.remove();
            System.out.println("【" + consume + "】消费了一个产品");
            list.notifyAll();
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
