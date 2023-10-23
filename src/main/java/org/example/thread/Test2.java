package org.example.thread;

public class Test2 {

    private static int x = 0;
    private static int y = 0;
    private static int a = 0;
    private static int b = 0;

    public static void main(String[] args) throws InterruptedException {
        // t1先运行完，然后t2再运行 结果为 a = 1, x = 0, b = 2, y = 1
        // t2先运行完，然后t1再运行 结果为 b = 2, y = 0, a = 1, x = 2
        // t1 t2交叉运行，t1先部分运行，t2完整运行 结果为 a = 1, b = 2, y = 1, x = 2
        // t1 t2交叉运行，t1先部分运行，t2也部分运行 结果为 a = 1, b = 2, x = 2, y = 1
        // t1 t2交叉运行，t2先部分运行，t1完整运行 结果为 b = 2, a = 1, x = 2, y = 1
        // t1 t2交叉运行，t2先部分运行，t1也部分运行 结果为 b = 2, a = 1, y = 1, x = 2

        for (int i = 0; i < 1000; i++) {
            a = 0;
            b = 0;
            x = 0;
            y = 0;
            // 重排的情况下： 可能出现 x = 0, y = 0
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        if (System.currentTimeMillis() % 8 == 0) {
                            Thread.sleep(1);
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    // 以下指令有可能出现指令重排
                    a = 1;
                    x = b;
                }
            });

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 2;
                    y = a;
                }
            });

            t1.start();
            t2.start();

            t1.join();
            t2.join();

            System.out.println("x = " + x + ", y = " + y + ", a = " + a + ", b = " + b);
        }
    }

}
