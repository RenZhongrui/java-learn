package com.learn.thread.stop;

/**
 * stop问题：使用stop api来停止线程，不会等线程执行完才停止
 * 例如模拟军队领取弹药，一共5个连队，每个连队10个人，
 * 要求是以连为单位进行领取，要么是整个连领取，要么是整个连都不领取，
 * 不能出现一个连里有的人领了有的人没领取，就无法判断这个连是不是已领取
 */
public class StopApiWrongWay implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            System.out.println("第" + i + "个连队开始领装备");
            for (int j = 1; j < 11; j++) {
                System.out.println(j);
                try {
                    // 每个士兵领取装备需要50毫秒时间
                    Thread.sleep(80);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("第" + i + "个连队领取完毕");
        }
    }


    public static void main(String[] args) {
        Thread thread = new Thread(new StopApiWrongWay());
        thread.start();
        try {
            // 1秒之后，要开赴前线，必须停止领取装备
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 1秒之后停止线程，
        // 如果使用stop()停止线程，则在第二个线程中会有部分士兵能够领取装备，
        // 部分士兵是领取不到设备的，所以是不合理的，我们要做的是按连队领取，要么都领，要么都不领
        // 正常应该判断领取时间是否足够或者是命令来的时候队伍是否在领取装备，如果在领取，则让领取完再走或把领取的设备退还再走
        // 然后再去停止线程
        thread.stop();
    }

}
