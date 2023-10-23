package org.example.asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 应用
 * 通过该类将功能作用到类上
 */
public class Generator {

    public static void main(String[] args) throws IOException {

        // 读取需要处理的类
        ClassReader cr = new ClassReader("org/example/asm/Foo");

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);

        // 应用
        ClassVisitor cv = new MyClassVisitor(cw);
        // 读取
        cr.accept(cv, ClassReader.SKIP_DEBUG);
        // 获得返回数组
        byte[] data = cw.toByteArray();

        // 输出成文件
        File f = new File("/");

        FileOutputStream fos = new FileOutputStream(f);
        fos.write(data);
        fos.close();

        System.out.println("Generator Foo ");
    }
}
