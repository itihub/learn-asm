package org.example.memory;


public class Test2 {

    private int num = 0;

    // 递归调用
    private int callMe(int a, int b) {
        num++;
        return callMe(a + num, b);
    }

    // 设置栈大小运行 -Xss1M
    public static void main(String[] args) {
        Test2 t = new Test2();
        try {
            // 递归调用最终会导致栈溢出
            t.callMe(1, 2);
        } catch (Throwable e) {
            System.out.println("num = " + t.num);
            e.printStackTrace();
        }
    }
}
