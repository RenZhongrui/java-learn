package com.learn.thread.create;

public class RunnableDemo implements Runnable {

    @Override
    public void run() {
        System.out.println("使用实现Runnable接口方式来创建线程");
    }
}
