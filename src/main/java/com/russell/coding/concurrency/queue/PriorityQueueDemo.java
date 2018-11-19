package com.russell.coding.concurrency.queue;

import lombok.Data;

import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 优先级阻塞队列demo
 *
 * @author liumenghao
 * @Date 2018/11/17
 */
public class PriorityQueueDemo {

    /**
     * 定义一个优先级阻塞队列
     */
    private static PriorityBlockingQueue priorityBlockingQueue;

    /**
     * 定义一个线程池
     */
    private static ThreadPoolExecutor executor;

    static {
        // 初始化优先级队列
        priorityBlockingQueue = new PriorityBlockingQueue<>(2000, new PeopleComparator());
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            // 随机产生不同身高的人
            People people = new People("小明"+i,random.nextInt(9) % 10 + 1);
            priorityBlockingQueue.put(people);
        }

        // 初始化线程池
        executor = new ThreadPoolExecutor(
                2,
                2,
                2,
                TimeUnit.MINUTES,
                priorityBlockingQueue,
                new ThreadPoolExecutor.AbortPolicy()
        );

    }

    /**
     * 定义一个比较器，身高越矮，优先级越高
     */
    public static class PeopleComparator implements Comparator<People> {

        @Override
        public int compare(People o1, People o2) {
            return o1.getHeight() - o2.getHeight();
        }
    }

    /**
     * People内部类
     */
    @Data
    public static class People implements Runnable{
        /**
         * 姓名
         */
        private String name;

        /**
         * 身高
         */
        private Integer height;

        public People(String name, Integer height){
            this.name = name;
            this.height = height;
        }

        @Override
        public void run() {
            System.out.println("姓名:" + name + " 身高:" + height + " 已就餐");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            executor.execute(new People("带头小明",0));
        }

    }
}
