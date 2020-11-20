package com.darren.service.classloader;

/**
 *
 * 类加载的过程
 * 加载 ->  连接（验证+准备+解析） -> 初始化
 *
 * public static int count = 2;
 * public static T t = new T();
 *
 * 加载  -> 准备 -> count=0;t=null -> 初始化 -> count=2; t:count=2+1=3 -> count=3
 *
 * public static T t = new T();
 * public static int count = 2;
 *
 * 加载  -> 准备 -> t=null;count=0 -> 初始化 -> t:count=0+1=1;count=2 -> 重新赋值：count=2
 */
public class ClassLoadingProcedure {

    public static void main(String[] args) {
        System.out.println(T.count);
    }

}

class T{
    public static int count = 2;
    public static T t = new T();

    public T() {
        count++;
    }
}


