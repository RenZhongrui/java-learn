package com.learn.thread.start;

import com.learn.thread.create.RunnableDemo;

/**
 *  比较两种启动方式
 */
public class TestStart {

    public static void main(String[] args) {
        // 第一种：使用run方法启动，打印main，说明在主线程中启动的，错误方式
        // run方法就是一个普通方法，不是启动线程的方法
        RunnableDemo runnableDemo = new RunnableDemo();
        runnableDemo.run();

        // 使用start方法启动，打印Thread-0，说明是创建子线程启动
        new Thread(new RunnableDemo()).start();
        /**
         * start工作方式：start最终会调用run方法，但是会做一些生命周期的准备工作
         * 在主线程中调用了start方法，会通知jvm虚拟机在空闲时启动子线程（启动时机由线程调度器控制）
         * 源码中：start方法由synchronized修饰，会保证线程安全
         * 1、检测线程状态，如果调用两次start方法会抛出异常，因为源码中有状态检测
         * 2、加入线程组
         * 3、调用start0
         *
         */
    }
}
