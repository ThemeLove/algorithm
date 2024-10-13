package com.lqs.algorithm.leetcode.linkedlist;

import com.lqs.algorithm.datastructure.ListNode;
import com.lqs.algorithm.datastructure.ListNodeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表的中间节点
 * create by lqs
 * date:2024-10-12
 */
public class LeetCode876_middleOfLinkedList {

    public static void main(String[] args) {

        ListNode head = ListNodeUtil.createNode(1, 2, 3, 4, 5);

        System.out.println("head before -> " + head);

        ListNode ans = middleNode3(head);

        System.out.println("ans -> " + ans);
    }

    /**
     * 单指针法，即遍历2此链表，第一次先获取链表长度，第二次根据长度遍历到中间节点即可
     *  Time O(n+1/2n) -> Time O(n)
     *  Space O(1)
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        int size = 0;
        ListNode cur = head;
        while(cur != null) {
            size++;
            cur = cur.next;
        }

        // 根据题意中间节点的index 为size/2

        int middleIndex = size/2;

        ListNode middle = head;
        for (int i = 0; i < middleIndex; i++) {
            middle = middle.next;
        }
        return middle;
    }


    /**
     * 快慢指针解法
     * 快指针每次走2步，慢指针每次走1步，快指针走到链表尾端的时候，慢指针走到中间，慢指针所在节点即为中间节点
     * 本质和单指针法是一模一样的，只是把单指针法的2次遍历合在一次遍历里
     * Time O(n) Space O(1)
     * @param head
     * @return
     */
    public static ListNode middleNode2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    /**
     * 数组存储法，空间还时间法
     * Time O(n)
     * Space O(n)
     * @param head
     * @return
     */
    public static ListNode middleNode3(ListNode head) {
        if (head == null || head.next == null) return head;

        List<ListNode> nodes = new ArrayList<>();

        while(head != null) {
            nodes.add(head);
            head = head.next;
        }

        return nodes.get(nodes.size()/2);
    }



}