package com.russell.coding.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liumenghao
 * @Date 2018/10/27
 */
@Slf4j
public class CountDownLatchExample {

    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    private static int count = 10;

    private static CountDownLatch latch = new CountDownLatch(count);

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < count; i++) {
            executorService.submit(() -> {
                try {
                    // 模拟线程拉取数据
                    Thread.sleep(1000);
                    log.info("线程{}, 拉取数据完成！", Thread.currentThread());
                }catch (InterruptedException e){
                    e.getMessage();
                }
                latch.countDown();
            });

        }
        latch.await();
        log.info("缓存初始化完成！");
    }
}
