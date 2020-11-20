package com.darren.service.gc;

import java.util.concurrent.TimeUnit;

/**
 * <h3>jvm-service</h3>
 * <p>其他线程等待一个线程释放锁</p>
 *
 * @author : Darren
 * @date : 2020年07月06日 14:49:59
 **/
public class TestDeadLock3 {

    static String lock = "lock";

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i == 0){
                Thread heldOnLock = new Thread(){
                    @Override
                    public void run() {
                        synchronized (lock){
                            System.out.println(Thread.currentThread().getName() + " held on lock");
                            while (true){

                            }
                        }
                    }
                };
                heldOnLock.setName("heldOnLock");
                heldOnLock.start();
            }else {
                new Thread(){
                    @Override
                    public void run() {
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (lock){
                            System.out.println(Thread.currentThread().getName());
                        }
                    }
                }.start();
            }
        }
    }

}
