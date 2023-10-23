package org.example.classinit;

public class MyClassA {

    private static MyClassA myClassA = new MyClassA();
    private static int a = 0;
    private static int b;

    private MyClassA() {
        a++;
        b++;
        System.out.println("now in MyClassA init() a = " + a + ", b = " + b);
    }

    public static MyClassA getInstance() {
        return myClassA;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
