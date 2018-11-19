package com.russell.coding.datastructure.linkedlist;

import java.util.Stack;

/**
 * Create by Russell
 **/
public class LinkNodeUtil {

    public static void print(LinkNode head) {
        LinkNode l1 = head;
        while (l1 != null) {
            System.out.println(l1.data);
            l1 = l1.next;
        }
    }

    public static int getLength(LinkNode head) {
        if (head == null) {
            return 0;
        }

        LinkNode l1 = head;
        int length = 0;
        while (l1 != null) {
            length++;
            l1 = l1.next;
        }
        return length;
    }

    public static int findLastNode(LinkNode head, int k) {
        if (head == null) {
            return -1;
        }

        LinkNode l1 = head;
        int size = 0;
        while (l1 != null) {
            size++;
            l1 = l1.next;
        }

        l1 = head;
        for (int i = 0; i < size - k; i++) {
            l1 = l1.next;
        }
        return l1.data;
    }

    public static LinkNode findLastNode1(LinkNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }

        LinkNode first = head;
        LinkNode second = head;

        while (k-- > 1) {
            first = first.next;
        }

        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        return second;

    }

    public static LinkNode findMiddleNode(LinkNode head) {
        LinkNode first = head;
        LinkNode second = head;

        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }

        return first;
    }

    public static LinkNode mergeTwoLinkNode(LinkNode head1, LinkNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }

        if (head1.data < head2.data) {
            head1.next = mergeTwoLinkNode(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeTwoLinkNode(head2.next, head1);
            return head2;
        }
    }

    public static LinkNode reverseLinkNode(LinkNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        LinkNode newHead = reverseLinkNode(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static LinkNode reverseLinkNode1(LinkNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        LinkNode pre = null;
        LinkNode cur = head;
        LinkNode temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;
    }

    public static void reservePrint(LinkNode head) {
        if (head == null) {
            return;
        }

        reverseLinkNode(head.next);
        System.out.println(head.data);
    }

    public static void reservePrint1(LinkNode head) {
        if (head == null) {
            return;
        }

        Stack<LinkNode> stack = new Stack<LinkNode>();
        LinkNode l1 = head;
        while (l1 != null) {
            stack.push(l1);
            l1 = l1.next;
        }

        while (stack.size() > 0) {
            System.out.println(stack.pop().data);
        }
    }

    public static LinkNode hasCycle(LinkNode head) {
        if (head == null) {
            return null;
        }

        LinkNode first = head;
        LinkNode second = head;

        while (second != null) {
            first = first.next;
            second = second.next.next;

            if (first == second) {
                return first;
            }
        }
        return null;
    }

    public static int getCycleLength(LinkNode head) {
        LinkNode node = hasCycle(head);
        if (node == null) {
            return -1;
        }

        int size = 0;
        LinkNode temp = node;
        while (node != null) {
            size++;
            node = node.next;
            if (temp == node) {
                return size;
            }
        }
        return size;
    }

    public static LinkNode getFirstCommonNode(LinkNode head1, LinkNode head2) {
        LinkNode l1 = head1;
        LinkNode l2 = head2;

        while (l1 != l2) {
            l1 = (l1 == null) ? head2 : l1.next;
            l2 = (l2 == null) ? head1 : l2.next;
        }
        return l1;
    }
}













