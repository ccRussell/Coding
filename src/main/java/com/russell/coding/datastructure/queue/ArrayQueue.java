package com.russell.coding.datastructure.queue;

/**
 * 使用数组实现一个队列
 * 非常简陋的实现
 *
 * @author liumenghao
 * @Date 2018/11/19
 */
public class ArrayQueue {

    /**
     * 代表队列的数组
     */
    private Integer[] items;

    /**
     * 表示队头下标
     */
    private int head;

    /**
     * 表示队尾下标
     */
    private int tail;

    /**
     * 队列的大小
     */
    private int size;

    /**
     * 构造方法
     * @param n
     */
    public ArrayQueue(int n){
        items = new Integer[n];
        this.size = n;
    }

    /**
     * 入队操作（队尾入队）
     *
     * @param item
     * @return
     */
    public boolean enqueue(Integer item){
        // 首先判断队列是否已满
        if(tail == size){
            // tail==size && head==0代表整个队列满了
            if(head == 0){
                return false;
            }
            for (int i = head; i < tail; i++) {
                items[i-head] = items[i];
            }
            tail = tail - head;
            head = 0;

        }
        items[tail] = item;
        tail++;
        return true;
    }

    /**
     * 出队操作
     *
     * @return
     */
    public Integer dequeue(){
        if(head == tail){
            return null;
        }
        Integer ret = items[head];
        head++;
        return ret;
    }
}
