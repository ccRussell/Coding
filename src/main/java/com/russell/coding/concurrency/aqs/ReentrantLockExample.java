package com.russell.coding.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liumenghao
 * @Date 2018/10/29
 */
@Slf4j
public class ReentrantLockExample {
    private static final ExecutorService executorService =
            Executors.newFixedThreadPool(20);

    private static ReentrantLock lock = new ReentrantLock();

    private static int count = 0;

    public static void main(String[] args) throws Exception{
        for (int i = 0; i < 10000; i++) {
            executorService.submit(() -> {
                addCount();
            });

        }
        Thread.sleep(1 * 1000);
        log.info("count = {}",count);

    }

    private static void addCount(){
        lock.lock();
        count++;
        lock.unlock();
    }
}
