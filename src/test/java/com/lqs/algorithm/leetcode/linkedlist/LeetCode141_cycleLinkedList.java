package com.lqs.algorithm.leetcode.linkedlist;

import com.lqs.algorithm.datastructure.ListNode;
import com.lqs.algorithm.datastructure.ListNodeUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * create by lqs
 * date:2024-10-11
 */
public class LeetCode141_cycleLinkedList {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        ListNode head = ListNodeUtil.createNodeWithNodes(node1, node2, node3, node4, node5, node3);

        boolean ans = hasCycle(head);

        System.out.println("ans -> " + ans);

    }


    /**
     * hash 法
     * @param head
     * @return
     */
    public static boolean hasCycle1(ListNode head) {
        if (head == null) return false;
        Set<ListNode> set = new HashSet<>();
        while(head != null) {
            if (set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }


    /**
     * 快慢指针法
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            if (fast == slow) return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

}