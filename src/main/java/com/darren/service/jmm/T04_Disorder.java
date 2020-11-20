package com.darren.service.jmm;

/**
 * <h3>jvm-service</h3>
 * <p>cpu指令乱序执行</p>
 *
 * 美团工程师实现
 *
 * @author : Darren
 * @date : 2020年06月29日 15:00:07
 **/
public class T04_Disorder {

    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        //死循环
        for (;;){
            i++;
            x = 0; y = 0;
            a = 0 ; b = 0;
            Thread t1 = new Thread() {
                @Override
                public void run() {
                    //等待线程二先执行
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    a = 1;
                    x = b;
                }
            };
            Thread t2 = new Thread() {
                @Override
                public void run() {
                    b = 1;
                    y = a;
                }
            };

            t1.start();t2.start();
            t1.join();t2.join();

            String result = "第" + i + "次（" + x + "," + y + "）";
            if (x == 0 && y == 0){
                System.out.println(result);
                break;
            }
        }
    }

}
