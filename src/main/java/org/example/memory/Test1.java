package org.example.memory;


import java.util.ArrayList;
import java.util.List;

public class Test1 {

    // 1M
    private byte[] bs = new byte[1024 * 1024];

    public static void main(String[] args) {

        List<Test1> list = new ArrayList<>();
        int num = 0;
        try {
            // 对次装载直到堆内存溢出
            while (true) {
                list.add(new Test1());
                num++;
            }
        } catch (Throwable e) {
            System.out.println("now error, num = " + num);
            e.printStackTrace();
        }
        System.out.println("totalMemory = " + Runtime.getRuntime().totalMemory() / 1024.0 / 1024.0);
        System.out.println("freeMemory = " + Runtime.getRuntime().freeMemory() / 1024.0 / 1024.0);
        System.out.println("maxMemory = " + Runtime.getRuntime().maxMemory() / 1024.0 / 1024.0);
    }
}
