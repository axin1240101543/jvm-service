package com.darren.service.Instruction;

/**
 * <h3>jvm-service</h3>
 * <p>测试</p>
 *
 * @author : Darren
 * @date : 2020年07月02日 11:23:49
 **/
public class Test003 {

    public void add(int a, int b){
        int c = a + b;
    }

    public static void main(String[] args) {
        Test003 t3 = new Test003();
        t3.add(3, 4);
    }
}
