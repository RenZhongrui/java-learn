package com.learn.thread.sixstate;

/**
 * 线程有6种状态
 * new 创建状态
 * runnable 可运行状态
 * blocked 被阻塞
 * waiting 等待
 * timed waiting 计时等待
 * terminated 已终止
 */

/**
 * 展示线程的New、Runnable、Terminated 三种状态
 * 即使是正在运行也是Runnable状态，而不是running
 */
public class NewRunnableTerminated implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i<1000; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new NewRunnableTerminated());
        System.out.println("new状态" + thread.getState());
        thread.start();
        System.out.println("Runnable状态" + thread.getState());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("正在运行时状态也是runnable状态：" + thread.getState());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程终止状态：" + thread.getState());
    }
}
