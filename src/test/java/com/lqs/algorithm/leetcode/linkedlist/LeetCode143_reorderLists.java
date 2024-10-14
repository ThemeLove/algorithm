package com.lqs.algorithm.leetcode.linkedlist;

import com.lqs.algorithm.datastructure.ListNode;
import com.lqs.algorithm.utils.ListNodeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * create by lqs
 * date:2024-10-12
 */
public class LeetCode143_reorderLists {

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.createNode(1, 2, 3, 4, 5, 6); // 1-5-2-4-3

        System.out.println("head before -> " + head);

        reorderList(head);

        System.out.println("head after -> " + head);
    }

    /**
     * 线性表的方法：因为链表不支持索引访问，并且是单向的，所以可以转化为线性表
     * Time O(n)
     * Space O(n)
     * @param head
     */
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        List<ListNode> nodes = new ArrayList<>();

        while (head != null) {
            ListNode next = head.next;
            // 去除各个节点之间的关联
            head.next = null;
            nodes.add(head);
            head = next;
        }

        int start = 0;
        int end = nodes.size() -1;

        int count = 0;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while(true) {
            cur.next = nodes.get(start);
            cur = cur.next;
            start++;
            count++;
            if (count >= nodes.size()) break;

            cur.next = nodes.get(end);
            cur = cur.next;
            end--;
            count++;
            if (count >= nodes.size()) break;
        }
        head = dummy.next;
    }

    /**
     * 看题解之后做的，主要是模拟过程
     * Time O(n)
     * Space O(1)
     * 1.找到链表的中间节点，将链表拆分为2个链表
     * 2.将后半部分链表反转
     * 3.依次便利2个链表，交替组合成新的链表
     * @param head
     */
    public static void reorderList2(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;

        // get middle node
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // split to two linked list
        ListNode list2 = slow.next;
        slow.next = null;

        // reverse list2;
        ListNode pre = null;
        while(list2 != null) {
            ListNode next = list2.next;
            list2.next = pre;
            pre = list2;
            list2 = next;
        }

        // now merge head and pre
        ListNode cur = head;
        while(cur != null && pre != null ){
            ListNode next = cur.next;
            ListNode pNext = pre.next;
            cur.next = pre;
            cur.next.next = next;
            cur = next;
            pre = pNext;
        }
    }

}