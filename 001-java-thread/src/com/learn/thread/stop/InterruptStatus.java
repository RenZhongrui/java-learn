package com.learn.thread.stop;

public class InterruptStatus {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                }
            }
        });
        thread.start();
        // 设置中断标志
        thread.interrupt();
        // 获取中断标志
        System.out.println("获取中断标志:"+thread.isInterrupted());
        // 会清除中断标志，interrupted()不管哪个线程调用的，清除的永远是执行他的线程，当前执行他的线程是主线程
        System.out.println("获取中断标志并重置：" + thread.interrupted());
        // 会清除当前线程的中断标志，当前是主线程，没有中断所以是false
        System.out.println("当前线程的中断标志:" + Thread.interrupted());
        // thread.isInterrupted()不会清除中断状态，所以依然是true
        System.out.println(thread.isInterrupted());
    }

}
