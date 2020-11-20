package com.darren.service.Instruction;

/**
 * <h3>jvm-service</h3>
 * <p>测试</p>
 *
 * @author : Darren
 * @date : 2020年07月02日 11:23:49
 **/
public class Test006 {

    public static void main(String[] args) {
        Test006 t3 = new Test006();
        int i = t3.m(3);
    }

    public int m(int n){
        if (n == 1){
            return 1;
        }
        return 1* m(n-1);
    }
}
