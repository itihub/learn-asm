package org.example.execute;

public class Test3 {

    public int add(int a, int b) {
        int c = a + b;
        return c;
    }

    public static void main(String[] args) {
        Test3 t = new Test3();
        int result = t.add(1, 2);
        System.out.println("result = " + result);
    }
}
