package com.learn.thread.create;

public class ThreadDemo extends Thread {

    @Override
    public void run() {
        super.run();
        System.out.println("使用继承Thread类方式进行创建");
    }
}
