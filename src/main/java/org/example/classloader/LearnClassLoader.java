package org.example.classloader;

public class LearnClassLoader {

    public static void main(String[] args) throws ClassNotFoundException {
        String str = "Hello Class Loader";
        System.out.println("str class loader = " + str.getClass().getClassLoader());
//        System.out.println("str parent class loader = " + str.getClass().getClassLoader().getParent());

        Class<?> driver = Class.forName("java.sql.Driver");
        System.out.println("driver class loader = " + driver.getClassLoader());
//        System.out.println("driver parent class loader = " + driver.getClassLoader().getParent());

        LearnClassLoader t = new LearnClassLoader();
        System.out.println("t class loader = " + t.getClass().getClassLoader());
        System.out.println("t parent class loader = " + t.getClass().getClassLoader().getParent());
        System.out.println("t parent.parent class loader = " + t.getClass().getClassLoader().getParent().getParent());

//        Class zipUtils = Class.forName("com.sun.nio.zipfs");
//        System.out.println("zipUtils class loader = " + zipUtils.getClassLoader());
        Class jshell = Class.forName("jdk.jshell.JShell");
        System.out.println("jshell class loader = " + jshell.getClassLoader());

        // 使用自定义ClassLoad
        MyClassLoader myClassLoader = new MyClassLoader("MyClassLoader1");
        Class cls1 = myClassLoader.loadClass("org.example.classloader.MyClass");
        System.out.println("cls1 class loader = " + cls1.getClassLoader());
        System.out.println("cls1 parent class loader = " + cls1.getClassLoader().getParent());

    }

}
