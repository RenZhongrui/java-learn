package com.learn.thread.create;

import com.learn.thread.create.RunnableDemo;
import com.learn.thread.create.ThreadDemo;

/**
 * 创建线程的两种方式
 */
public class Test {

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.run();

        RunnableDemo runnableDemo = new RunnableDemo();
        runnableDemo.run();
    }
}
