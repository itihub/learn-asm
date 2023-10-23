package org.example.gc;

public class HelpSelf {

    private static HelpSelf hs = null;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("now in finalize 自救");
        // 重新引用来进行自救
        hs = this;
    }

    public static void main(String[] args) throws InterruptedException {
        hs = new HelpSelf();

        // 第一次 设置为空
        hs = null;

        // 尝试执行垃圾回收
        System.gc();
        Thread.sleep(100L);

        System.out.println("first hs = " + hs);

        // 第二次 设置为空
        hs = null;

        // 尝试执行垃圾回收
        System.gc();
        Thread.sleep(100L);

        System.out.println("second hs = " + hs);
    }
}
