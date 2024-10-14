package com.lqs.algorithm.leetcode.linkedlist;

import com.lqs.algorithm.datastructure.ListNode;
import com.lqs.algorithm.utils.ListNodeUtil;
/**
 * create by lqs
 * date:2024-10-11
 */
public class LeetCode92_reverseLinkedListII {

    public static void main(String[] args) {

        ListNode head = ListNodeUtil.createNode(1, 2, 3, 4, 5);

        System.out.println("head before -> " + head);

        ListNode ans = reverseBetween(head, 2, 4);

        System.out.println("ans -> " + ans);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode p0 = dummy;

        for (int i = 0; i < left-1; i++) {
            p0 = p0.next;
        }

        ListNode pre = null;
        ListNode cur = p0.next;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        p0.next.next = cur;
        p0.next = pre;

        return dummy.next;
    }
}