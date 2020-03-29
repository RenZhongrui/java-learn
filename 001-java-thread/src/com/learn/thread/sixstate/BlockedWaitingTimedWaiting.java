package com.learn.thread.sixstate;

/**
 * 展示Blocked、Waiting 、timed Waiting三种状态
 */
public class BlockedWaitingTimedWaiting implements Runnable {

    @Override
    public void run() {
        sync();
    }

    // 第一个线程执行的时候这个方法锁没有被释放
    private synchronized void sync() {
        try {
            Thread.sleep(1000);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BlockedWaitingTimedWaiting runnable = new BlockedWaitingTimedWaiting();
        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread thread2 = new Thread(runnable);
        thread2.start();
        // TIMED_WAITING状态，因为正在执行Thread.sleep(10000)
        System.out.println(thread1.getState());
        // 打印的是blocked状态，因为线程2想拿到sync方法的锁却线程1还没释放，拿不到就是阻塞状态
        System.out.println(thread2.getState());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // wait(); 等待时才会WAITING
        System.out.println(thread1.getState());
    }
}
