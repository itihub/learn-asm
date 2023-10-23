package org.example.thread;

public class A {

    private volatile int a;

    /**
     * 即使变量a使用volatile修饰，也是线程不安全的
     * 使用synchronized修饰确保线程安全
     */
    public synchronized void aPlus() {
        a++;
    }

    public int getA() {
        return this.a;
    }
}
