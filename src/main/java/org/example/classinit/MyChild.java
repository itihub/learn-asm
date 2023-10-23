package org.example.classinit;

public class MyChild extends MyParent implements Api {

    static {
        System.out.println("my child class init");
    }

    static {
        System.out.println("my child static block 2");
    }

    private static int a = 5;

    static {
        System.out.println("my child static block 3 = " + a);
    }

    @Override
    public void t1() {
        System.out.println("now in mychild t1()");
    }
}
