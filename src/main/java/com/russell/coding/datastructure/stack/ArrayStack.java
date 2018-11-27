package com.russell.coding.datastructure.stack;

/**
 * 基于数组实现的顺序栈
 *
 * @author liumenghao
 * @Date 2018/11/19
 */
public class ArrayStack {

    /**
     * 代表栈的数组
     */
    private int[] items;

    /**
     * 栈中元素的数量
     */
    private int num;

    /**
     * 栈的大小
     */
    private int size;

    /**
     * 初始化一块大小为n的栈空间
     *
     * @param n
     */
    public ArrayStack(int n){
        items = new int[n];
        this.size = n;
    }

    /**
     * 入栈操作
     *
     * @param data
     */
    public boolean push(int data){
        if(num == size){
            return false;
        }
        items[num] = data;
        num++;
        return true;
    }

    /**
     * 出栈操作
     *
     * @return
     */
    public Integer pop(){
        if(num == 0){
            return null;
        }
        int item = items[num -1];
        num--;
        return item;
    }
}
