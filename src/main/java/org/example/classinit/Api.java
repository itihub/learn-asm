package org.example.classinit;

public interface Api {

    public static String str = "now in api";

    public void t1();

    public default void t3() {
        System.out.println("now in api t3()");
    }
}
