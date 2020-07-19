package com.vidor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FinalizeTest {

    static List<Object> list = new ArrayList<>();
    public static void main(String[] args) {

        int i = 0;
        int j = 0;
        while (true) {
            list.add(new User1(i++, UUID.randomUUID().toString()));
            new User1(j--, UUID.randomUUID().toString());
        }
    }

    private static class User1 {
        public User1(int i, String s) {
        }
    }

    //User类需要重写finalize方法
    @Override
    protected void finalize() throws Throwable {
        FinalizeTest.list.add(this);
        System.out.println("关闭资源，userid=" + "即将被回收");
    }
}
