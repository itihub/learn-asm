package org.example.asm;

/**
 * 需要被增强的原始类
 */
public class Foo {

    public void m1() {

        System.out.println("now in method m1 ----->");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
