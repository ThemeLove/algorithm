package com.lqs.algorithm.leetcode.linkedlist;

import com.lqs.algorithm.datastructure.ListNode;
import com.lqs.algorithm.datastructure.ListNodeUtil;
/**
 * 移除链表元素
 *
 * create by lqs
 * date:2024-10-10
 */
public class LeetCode203_RemoveLinkedListElement {

    public static void main(String[] args) {

        ListNode node = ListNodeUtil.createNode(1, 2, 6, 3, 4, 5, 6);

        ListNode ans = removeElements(node, 2);

        System.out.println("ans -> " + ans);
    }

    public static ListNode removeElements(ListNode head, int val) {
        // create virtual head node
        ListNode pHead = new ListNode();
        pHead.next = head;
        ListNode cur = pHead;
        while(cur != null) {
            while (cur.next != null && cur.next.val == val) {// need remove, update next point
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return pHead.next;
    }

}