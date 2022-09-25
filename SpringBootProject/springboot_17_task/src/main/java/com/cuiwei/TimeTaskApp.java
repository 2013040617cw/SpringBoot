package com.cuiwei;

import java.util.Timer;
import java.util.TimerTask;

public class TimeTaskApp {
    public static void main(String[] args) {
        Timer timer = new Timer();

        //每隔两秒运行一次任务
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("我是崔巍大帅哥");
            }
        };
        timer.schedule(task,0,2000);

    }
}
