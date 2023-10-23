package org.example.thread;

public class Test {

    public static void main(String[] args) throws Exception {
        A a = new A();

        Thread t1 = new Thread(new MyThread(a, "t1"));
        Thread t2 = new Thread(new MyThread(a, "t2"));
        t1.start();
        t2.start();

        // 主线程等待子线程执行完成才继续执行
        t1.join();
        t2.join();

        System.out.println("A.a = " + a.getA());
    }
}
