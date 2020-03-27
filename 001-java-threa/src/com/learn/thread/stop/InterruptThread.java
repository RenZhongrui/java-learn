package com.learn.thread.stop;

public class InterruptThread implements Runnable {

    @Override
    public void run() {
        int num = 0;
        // 判断当前线程是否被打断，是否有打断信号
        while (!Thread.currentThread().isInterrupted() && num < Integer.MAX_VALUE / 2) {
            if (num % 1000 == 0) {
                System.out.println(num+"是10000的倍数");
            }
            num++;
        }
    }

    public static void main(String[] args) {
        try {
            Thread thread = new Thread(new InterruptThread());
            thread.start();
            // 1秒过后发送中断线程的信号
            Thread.sleep(1000);
            thread.interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
