package com.learn.thread.create;

import com.learn.thread.create.RunnableDemo;
import com.learn.thread.create.ThreadDemo;

/**
 * 创建线程的两种方式
 */
public class Test {

    public static void main(String[] args) {
        // 启动ThreadDemo线程
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();

        // 启动RunnableDemo线程
        new Thread(new RunnableDemo()).start();
    }
}
