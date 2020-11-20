package com.darren.service.gc;

import java.util.LinkedList;
import java.util.List;

/**
 * <h3>jvm-service</h3>
 * <p>测试fgc</p>
 *
 * @author : Darren
 * @date : 2020年07月03日 16:05:22
 **/
public class fgc {

    public static void main(String[] args) {
        System.out.println("Hello GC");
        List<byte[]> list = new LinkedList<>();
        for (;;) {
            byte[] b = new byte[1024*1024];
            list.add(b);
        }
    }

}
