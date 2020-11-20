package com.darren.service.gc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <h3>jvm-service</h3>
 * <p>死锁实现2，使用jstack观察线程栈</p>
 *
 * @author : Darren
 * @date : 2020年07月06日 14:07:53
 **/
public class TestDeadLock2 {

    static ReentrantLock lock1 = new ReentrantLock();
    static ReentrantLock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                try {
                    lock1.lock();
                    TimeUnit.SECONDS.sleep(1);
                    lock2.lock();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                try {
                    lock2.lock();
                    TimeUnit.SECONDS.sleep(1);
                    lock1.lock();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        t1.setName("my t1");
        t2.setName("my t2");
        t1.start();
        t2.start();
    }

}