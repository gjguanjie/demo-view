package com.cloud;

import com.cloud.config.DistributedLocker;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class DemoRedissonApplicationTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoRedissonApplicationTests.class);

    @Resource
    private DistributedLocker distributedLocker ;

    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Test
    void contextLoads() throws InterruptedException {

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                LOGGER.info("执行定时任务");
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread());
                        distributedLocker.lock("lock");
                        LOGGER.info("获取锁");
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            LOGGER.info("释放锁");
                            distributedLocker.unlock("lock");
                        }
                    }
                });
            }
        },100,1000, TimeUnit.MILLISECONDS);

        Thread.sleep(100000);

    }

}
