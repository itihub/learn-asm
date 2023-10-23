package org.example.gc;

public class User {

    // 设置数字大小，主要用于测试占用堆空间
    private byte[] bs = new byte[100 * 1024];

    private String userId;

    public User(String userId) {
        this.userId = userId;
    }

    /**
     * GC第一次回收会被调用
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("now finalize userId = " + userId);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                '}';
    }
}
