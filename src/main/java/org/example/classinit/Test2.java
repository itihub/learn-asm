package org.example.classinit;

public class Test2 {

    public static void main(String[] args) {
        MyChild myChild = new MyChild();
        // 演示：只有当程序首次使用接口里面的变量或者是调用接口方法的时候，才会导致接口初始化
        System.out.println("myChild.str = " + myChild.str);
    }
}
