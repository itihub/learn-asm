package org.example.classinit;

public class Test3 {

    public static void main(String[] args) {
        MyClassA myClassA = MyClassA.getInstance();
        System.out.println("myClassA.a = " + myClassA.getA());
        System.out.println("myClassA.b = " + myClassA.getB());
    }
}
