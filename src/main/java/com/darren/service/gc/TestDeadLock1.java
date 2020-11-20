package com.darren.service.gc;

/**
 * <h3>jvm-service</h3>
 * <p>死锁实现1，使用jstack观察线程栈</p>
 *
 * @author : Darren
 * @date : 2020年07月06日 14:07:53
 **/
public class TestDeadLock1 {

    public static String lock1 = "lock1";
    public static String lock2 = "lock2";

    public static void main(String[] args) {
        LockA la = new LockA();
        LockB lb = new LockB();
        new Thread(la).start();
        new Thread(lb).start();
    }

}
    class LockA implements Runnable{

        @Override
        public void run() {
            System.out.println("begin lockA");
            while (true){
                synchronized (TestDeadLock1.lock1){
                    System.out.println("lockA held on lock1");
                    synchronized (TestDeadLock1.lock2){
                        System.out.println("lockA held on lock2");
                        try {
                            Thread.sleep(60 * 60);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    class LockB implements Runnable{

        @Override
        public void run() {
            System.out.println("begin lockB");
            while (true){
                synchronized (TestDeadLock1.lock2){
                    System.out.println("lockB held on lock2");
                    synchronized (TestDeadLock1.lock1){
                        System.out.println("lockB held on lock1");
                        try {
                            Thread.sleep(60 * 60);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }