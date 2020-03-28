package com.learn.thread.stop;

public class RightWayToStopThread implements Runnable {
    @Override
    public void run() {
        int num = 0;
        while (true && !Thread.currentThread().isInterrupted()) {
            System.out.println("go");
            try {
                interruptAction();
            } catch (InterruptedException e) {
                // 保存日志，停止程序
                System.out.println("抛出异常后，就中断线程");
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            reInterruptAction();
        }
    }

    // 第一种中止程序的方法，在方法上抛出异常，让顶层run方法处理异常，增强了代码的健壮性
    public void interruptAction() throws InterruptedException {
        Thread.sleep(2000);
    }
    // 第二种中止程序的方法
    public void reInterruptAction() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("抛出异常后，就中断线程");
            // 恢复中断状态
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RightWayToStopThread());
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
