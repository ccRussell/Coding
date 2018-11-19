package com.russell.coding.datastructure.linkedlist;

/**
 * Create by Russell
 **/
public class Main {
    public static void main(String[] args) {
        LinkNode head = new LinkNode(1);
        LinkNode l1 = new LinkNode(2);
        LinkNode l2 = new LinkNode(3);
        LinkNode l3 = new LinkNode(4);

        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = null;

        LinkNode result = LinkNodeUtil.reverseLinkNode1(head);
        LinkNodeUtil.print(result);
    }
}
