package com.russell.coding.datastructure.linkedlist;

import lombok.extern.slf4j.Slf4j;

/**
 * 操作链表的各种方法
 *
 * @author liumenghao
 * @Date 2018/11/19
 */
@Slf4j
public class LinkedNodeUtil {

    /**
     * 给出链表头节点，打印链表
     *
     * @param head
     */
    public static void print(LinkedNode head) {
        LinkedNode l1 = head;
        while (l1 != null) {
            System.out.println(l1.data);
            l1 = l1.next;
        }
    }

    /**
     * 得到链表的长度
     *
     * @param head
     * @return
     */
    public static int getLength(LinkedNode head) {
        if (head == null) {
            return 0;
        }
        LinkedNode l1 = head;
        int length = 0;
        while (l1 != null) {
            length++;
            l1 = l1.next;
        }
        return length;
    }

    /**
     * 得到链表的倒数第k个节点
     *
     * @param head
     * @return
     */
    public static LinkedNode findLastNode(LinkedNode head, int k){
        return null;
    }

    /**
     * 合并两个有序链表，并且使得合并后的链表是有序的
     *
     * @param head1
     * @param head2
     * @return
     */
    public static LinkedNode mergeTwoNodes(LinkedNode head1, LinkedNode head2){
        return null;
    }

    /**
     * 单链表反转
     *
     * @param head
     * @return
     */
    public static LinkedNode reverseLinkedNode(LinkedNode head){
        return null;
    }

    /**
     * 判断链表是否有环
     *
     * @param head
     * @return
     */
    public Boolean hasCycle(LinkedNode head){
       return null;
    }

    /**
     * 获取链表中环的长度
     *
     * @param head
     * @return
     */
    public static int getCycleLength(LinkedNode head){
        return 0;
    }
}
