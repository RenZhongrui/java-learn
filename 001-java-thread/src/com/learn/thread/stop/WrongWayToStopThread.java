package com.learn.thread.stop;

public class WrongWayToStopThread implements Runnable{
    @Override
    public void run() {
        int num = 0;
        while (true && !Thread.currentThread().isInterrupted()) {
            System.out.println("go");
            interruptAction();
        }
    }

    // 中止程序的方法
    public void interruptAction() {
        try {
            // 此处的try-catch会把中断信号给吞掉，所以无法中止线程
            Thread.sleep(2000);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Thread thread = new Thread(new WrongWayToStopThread());
        thread.start();
        try {
            Thread.sleep(1000);
            // 执行了interrupt后，程序还会执行到go
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
