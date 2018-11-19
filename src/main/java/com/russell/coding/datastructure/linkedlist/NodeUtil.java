package com.russell.coding.datastructure.linkedlist;

/**
 * Create by Russell
 **/
public class NodeUtil {

    public int getLength(LinkNode head){
        int size = 0;
        LinkNode l1 = head;
        while(l1!=null){
            l1 = l1.next;
            size++;
        }
        return size;
    }

    public int findLastNode(LinkNode head,int k){
        
        if(head == null){
            return -1; 
        }
        LinkNode l1 = head;
        int size = 0;
        while(l1!=null){
            l1 = l1.next;
            size++;
        }

        l1 = head;
        for (int i = 0; i < size - k; i++) {
            l1 = l1.next;
        }
        return l1.data;
    }

    public int findLastNode1(LinkNode head,int k){
        LinkNode first = head;
        LinkNode last = head;

        for (int i = 0; i < k; i++) {
            first = first.next;
        }

        while(first != null){
            first = first.next;
            last = last.next;
        }

        return last.data;
    }

    public LinkNode findMiddelModel(LinkNode head){

        if(head == null || head.next == null){
            return head;

        }
        LinkNode first = head;
        LinkNode last = head;

        while(last.next != null){
            first = first.next;
            last = last.next.next;
        }

        return first;
    }

    public LinkNode mergeTwoLinkModel(LinkNode head1,LinkNode head2){
        LinkNode l1 = head1;
        LinkNode l2 = head2;

        LinkNode head = new LinkNode(-1);
        LinkNode l = head;
        while(l1!=null || l2!=null){
            if(l1 == null){
                l.next = l2;
                l2 = l2.next;
            }else if(l2 == null){
                l.next = l1;
                l1 = l1.next;
            }else{
                if(l1.data < l2.data){
                    l.next = l1;
                    l1 = l1.next;
                }else{
                    l.next = l2;
                    l2 = l2.next;
                }
            }
            l = l.next;
        }
        return head.next;
    }

    public LinkNode mergeTwoLinkModel1(LinkNode head1,LinkNode head2){
        if(head1 == null || head2 == null){
            return (head1 == null)? head2:head1;
        }
        LinkNode l1 = head1;
        LinkNode l2 = head2;
        if(l1.data < l2.data){
            l1.next = mergeTwoLinkModel1(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLinkModel1(l2.next,l1);
            return l2;
        }
    }

    public LinkNode reserveLink(LinkNode head){
        if(head == null || head.next == null){
            return head;
        }
        LinkNode temp = reserveLink(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

    public LinkNode reserveLink1(LinkNode head){
        if(head == null || head.next == null){
            return head;
        }
        LinkNode pre = null;
        LinkNode cur = head;
        LinkNode temp = null;
        while(cur != null){
            cur.next = temp;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return cur;
    }

    public void reservePrint(LinkNode head){
        if(head == null){
            return;
        }
        reserveLink(head.next);
        System.out.println(head.data);
    }

    public LinkNode hasCycle(LinkNode head){
        LinkNode first = head;
        LinkNode second = head;

        while(second != null){
            first = first.next;
            second = second.next.next;
            if(first == second){
                return first;
            }
        }
        return null;
    }

    public int getCycleLength(LinkNode head){
        LinkNode point = hasCycle(head);
        LinkNode l1 = point;
        int size = 0;
        while(l1 != null){
            l1 = l1.next;
            size++;
            if(l1 == point){
                return size;
            }
        }
        return 0;
    }

    public LinkNode getCyclePoint(LinkNode head){
        int cycleLength = getCycleLength(head);
        LinkNode first = head;
        LinkNode second = head;
        for (int i = 0; i < cycleLength; i++) {
            first = first.next;
        }

        while(first != second){
            first = first.next;
            second = second.next;
        }
        return first;
    }

    public LinkNode getFirstCommonNode(LinkNode head1,LinkNode head2){
        LinkNode l1 = head1;
        LinkNode l2 = head2;

        while (l1 != l2) {
            l1 = (l1 == null) ? head2 : l1.next;
            l2 = (l2 == null) ? head1 : l2.next;
        }
        return l1;
    }
}
