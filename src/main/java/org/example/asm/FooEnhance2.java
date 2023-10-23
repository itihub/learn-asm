package org.example.asm;

/**
 * 增强后的类
 */
public class FooEnhance2 {

    public void m1() {
        MyTimeLogger.start();

        System.out.println("now in method m1 ----->");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MyTimeLogger.end();
//        System.out.println("invoke method total time====" + (a2 - a1));
    }

}
