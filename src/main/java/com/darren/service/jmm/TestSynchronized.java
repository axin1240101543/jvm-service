package com.darren.service.jmm;

/**
 * <h3>jvm-service</h3>
 * <p>测试synchronized关键字生成的bytecode</p>
 *
 * @author : Darren
 * @date : 2020年06月29日 17:01:20
 **/
public class TestSynchronized {

    synchronized void a(){

    }

    void b(){
        synchronized (this){

        }
    }

    public static void main(String[] args) {

    }

}
