package com.russell.coding.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author liumenghao
 * @Date 2018/11/7
 */
@Slf4j
public class FutureExample {

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<String> future = executorService.submit(new MyCallable());
        log.info("do something in main");
        Thread.sleep(1000);
        // 如果拿不到另外一个线程的执行结果，则会阻塞
        String result = future.get();
        log.info(result);
        executorService.shutdown();
    }

    public static class MyCallable implements Callable{

        @Override
        public String call() throws Exception {
            log.info("do something in callable");
            Thread.sleep(5000);
            return "done";
        }
    }
}
