package org.example.execute;

public class Test1 {

    /**
     * 这个方法中的a,b,c变量都是局部变量
     */
    public int add(int a, int b) {
        int c = a + b;
        return c;

        // slot 局部变量表的槽位分配
        // 0 -> this 指向Test1的实例
        // 1 -> a
        // 2 -> b
        // 3 -> c
    }

    public static int addS(int a, int b) {
        int c = a + b;
        return c;
        // slot 静态方法局部变量表的槽位分配
        // 0 -> a
        // 1 -> b
        // 2 -> c
    }
}
