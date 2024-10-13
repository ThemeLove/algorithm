package com.lqs.algorithm.leetcode.linkedlist;

import com.lqs.algorithm.datastructure.ListNode;
import com.lqs.algorithm.datastructure.ListNodeUtil;
/**
 * create by lqs
 * date:2024-10-11
 */
public class LeetCode25_reverseNodesInKGroup {

    public static void main(String[] args) {

        ListNode head = ListNodeUtil.createNode(1, 2, 3, 4, 5, 6, 7, 8);

        System.out.println("head before -> " + head);

        ListNode ans = reverseKGroup(head, 2);

        System.out.println("ans -> " + ans);

    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        int size = 0;
        ListNode temp = head;
        while(temp != null) {
            size++;
            temp = temp.next;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p0 = dummyHead;
        ListNode cur = p0.next;
        ListNode pre = null;
        while(size >= k) {
            size -= k;
            for (int i = 0; i < k; i++) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            ListNode  next = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = next;
        }

        return dummyHead.next;
    }


}