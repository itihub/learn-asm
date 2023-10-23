package org.example.execute;

public class Test2 {

    public int add(int a, int b) {
        int c = a + b;
        return c;
    }

    public static void main(String[] args) {
        byte[] bs = new byte[2 * 1024 * 1024];
//        byte[] bs2 = new byte[2 * 1024 * 1024];
        // 此时的solt槽分配
        // 0 -> args
        // 1 -> bs

        int a = 5;
        // 再次定义变量a 此时的solt槽分配
        // 0 -> args
        // 1 -> a 因为bs变量后续不再使用了槽位1被复用 节省栈帧的空间

        // 尝试触发GC 让bs变量被回收
        // GC无法回收bs变量，因为方法还没有执行完成，本地变量表还在引用bc
        System.gc();

        System.out.println("totalMemory = " + Runtime.getRuntime().totalMemory());
        System.out.println("freeMemory = " + Runtime.getRuntime().freeMemory());
        System.out.println("maxMemory = " + Runtime.getRuntime().maxMemory());
    }
}
