package com.example.scheduledtest.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @className ScheduledTest
 * @Author shenguang
 * @Description
 * @Date 2019/4/16 11:46
 **/
//@Service
public class ScheduledTest {
    private int count=0;

    @Scheduled(cron="*/1 * * * * ?")
    private void process(){

        System.out.println("this is scheduler task runing  "+(count++));
        System.out.println("当前job执行完毕");
    }

}
