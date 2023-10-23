package org.example.classloader;

import org.example.asm.MyClassVisitor;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {

    private String myName = "";

    public MyClassLoader(String myName) {
        this.myName = myName;
    }

    // 覆盖findClass方法
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = this.loadClassData(name);
        // 将二进制内容转换为类
        return this.defineClass(name, data, 0, data.length);
    }

    // 装载class内容的方法
    private byte[] loadClassData(String clsName) {
        byte[] data = null;

        // 替换引用为路径
        clsName = clsName.replace(".", "/");

        // 读class文件
        try (InputStream in = new FileInputStream(new File("classes/" + clsName + ".class"));
             ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            int a = 0;
            while ((a = in.read()) != -1) {
                out.write(a);
            }
            data = out.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
