package com.lqs.algorithm.leetcode.linkedlist;


import com.lqs.algorithm.datastructure.ListNode;
import com.lqs.algorithm.datastructure.ListNodeUtil;

/**
 * 删除链表中倒数第N个节点
 * create by lqs
 * date:2024-10-11
 */
public class LeetCode19_removeNthNodeFromEnd {

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.createNode(1, 2, 3, 4, 5);

        System.out.println("head - before -> " + head);

        ListNode ans = removeNthNodeFromEnd2(head, 0);

        System.out.println("ans -> " + ans);
    }

    /**
     * 快慢指针做法
     * Time O(n) 快指针从头到尾遍历一次
     * Space O(1) 定义了快 慢 2 个指针
     * @param head
     * @return
     */
    public static ListNode removeNthNodeFromEnd(ListNode head, int n) {
        if (head == null || n < 0) return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // define fast slow point
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        // move fast point first
        while(n-- >=0 && fast != null) {
            fast = fast.next;
        }

        // move fast slow together until fast reach end
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // remove Nth node from end
        if (slow.next != null) { // 如果n=0时，不处理会空指针
            slow.next = slow.next.next;
        }
        return dummyHead.next;
    }

    /**
     * 常规思路，先遍历一遍计算出链表长度，第二遍遍历删除元素
     * 时间复杂度分析 先遍历一次获取size, O(m) m 为链表长度，再遍历n, 所以总的Time O(m+n)
     * 空间复杂度分析，定义了临时节点 dummyHead, Space O(1)
     *
     * 本质上该种方法和双指针方法一摸一样
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthNodeFromEnd2(ListNode head, int n) {
        if (head == null || n <= 0) return head;

        // 添加虚拟头节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode cur = dummyHead;
        int size = 0;
        while(cur.next != null) {
            size++;
            cur = cur.next;
        }

        ListNode curr = dummyHead;
        for (int i = 0; i < size - n; i++) {
            curr = curr.next;
        }

        if (curr.next != null) {
            curr.next = curr.next.next;
        }
        return dummyHead.next;
    }

}