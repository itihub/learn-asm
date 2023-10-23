package org.example.gc;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class WeakReferenceTest {

    // 队列
    private static ReferenceQueue<User> rq = new ReferenceQueue<>();

    /**
     * 软引用
     */
    private static void testWeakReference() throws InterruptedException {
        List<WeakReference<User>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            // 创建软引用对象并放入队列中
            WeakReference<User> user = new WeakReference<>(new User("soft" + i), rq);
            System.out.println("now the soft user = " + user.get());
            list.add(user);
        }

        // 尝试触发垃圾回收
        System.gc();

        Thread.sleep(1000L);

        printQueue("weak");
    }

    /**
     * 获取弱引用对象并打印（用于观察软引用是否被回收）
     * @param str
     */
    private static void printQueue(String str) {
        Reference<? extends User> obj = rq.poll();
        if (obj != null) {
            System.out.println("the gc Object reference = " + obj.get());
        }
    }

    /**
     * 测试观察弱引用被回收
     * 设置JVM启动参数限制内存 -XX:+UseConcMarkSweepGC -Xms2M -Xmx2M -Xlog:gc+heap=debug
     */
    public static void main(String[] args) throws InterruptedException {
        testWeakReference();
    }
}
