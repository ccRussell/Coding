package com.russell.coding.datastructure.linkedlist;

import lombok.Data;

/**
 * 单链表节点
 *
 * @author liumenghao
 * @Date 2018/11/19
 */
@Data
public class LinkedNode {

    /**
     * 节点数据
     */
    public int data;

    /**
     * 后继节点
     */
    public LinkedNode next;

    public LinkedNode(int data){
        this.data = data;
    }
}
