package org.example.asm;

/**
 * 增强后的类
 * 用局部变量的方式去做方法执行时间会跟原来类的局部变量发生冲突导致执行错误
 * 尽量使用封装的方式做增强(方法调用) 避免与原本类的局部变量发生冲突
 */
public class FooEnhance {

    public void m1() {
        long a1 = System.currentTimeMillis();

        System.out.println("now in method m1 ----->");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long a2 = System.currentTimeMillis();
        System.out.println("invoke method total time====" + (a2 - a1));
    }

}
