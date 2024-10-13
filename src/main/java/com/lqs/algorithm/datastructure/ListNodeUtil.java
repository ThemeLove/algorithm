package com.lqs.algorithm.datastructure;

/**
 * create by lqs
 * date:2024-09-12
 */
public class ListNodeUtil {

    public static ListNode createNode(int... args) {
        ListNode headNode = null;
        ListNode preNode = null;
        int start = 0;
        while(start < args.length) {
            int val = args[start];
            ListNode listNode = new ListNode(val);
            if (start == 0) {
                headNode = listNode;
            }
            if (preNode != null) {
                preNode.next = listNode;
                preNode = listNode;
            } else {
                preNode = listNode;
            }
            ++ start;
        }
        return headNode;
    }

    public static ListNode createNodeWithNodes(ListNode... nodes) {
        if (nodes == null || nodes.length == 0) return null;
        ListNode pre = null;
        for (int i = 0; i < nodes.length; i++) {
            if (pre != null) {
                pre.next = nodes[i];
            }
            pre = nodes[i];
        }
        return nodes[0];
    }

}