package com.lqs.algorithm.leetcode.linkedlist;

import com.lqs.algorithm.datastructure.ListNode;
import com.lqs.algorithm.datastructure.ListNodeUtil;
/**
 * create by lqs
 * date:2024-10-11
 */
public class LeetCode24_SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.createNode(1, 2, 3, 4, 5, 6);

        System.out.println("head before -> " + head);

        ListNode ans = swapPairs(head);

        System.out.println("ans -> " + ans);
    }

    // 1->2->3->4->5
    // 2->1->4->3->5
    // 0->1->2->3->4->5
    // 0->2->1->3->4->5
    public static ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while(cur.next != null && cur.next.next != null) {
            // define temp var
            ListNode nextTemp = cur.next;
            ListNode nextNextTemp = cur.next.next;

            cur.next.next = cur.next.next.next; // 1->3
            cur.next = nextNextTemp; // 0->2
            nextNextTemp.next = nextTemp; // 2->1

            cur = nextTemp; // cur -> 1
        }
        return dummyHead.next;
    }
}