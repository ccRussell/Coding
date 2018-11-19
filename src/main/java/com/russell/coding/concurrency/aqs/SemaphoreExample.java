package com.russell.coding.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author liumenghao
 * @Date 2018/10/27
 */
@Slf4j
public class SemaphoreExample {
    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    private static int threadCount = 3;

    private static int threadTotal = 10;

    private static Semaphore semaphore = new Semaphore(threadCount);

    private static CountDownLatch latch = new CountDownLatch(threadTotal);

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < threadTotal; i++) {
            executorService.submit(() -> {
                try {
                    semaphore.acquire();
                    // 模拟线程拉取数据
                    Thread.sleep(5000);
                    log.info("线程{}, 拉取数据完成！", Thread.currentThread());
                }catch (InterruptedException e){
                    e.getMessage();
                }
                latch.countDown();
                semaphore.release();
            });

        }
        latch.await();
        log.info("缓存初始化完成！");
    }
}
