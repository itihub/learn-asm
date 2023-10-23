package org.example.classinit;

public class Test1 {

    public static void main(String[] args) {
        // 演示：如果类存在父类，且父类没有初始化，就先初始化父类
        MyChild myChild = new MyChild();
        // 控制台输出
        // my parent class init
        // my child class init
    }
}
