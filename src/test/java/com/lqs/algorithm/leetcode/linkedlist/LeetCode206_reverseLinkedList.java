package com.lqs.algorithm.leetcode.linkedlist;

import com.lqs.algorithm.datastructure.ListNode;
import com.lqs.algorithm.datastructure.ListNodeUtil;
/**
 * 翻转链表
 * create by lqs
 * date:2024-10-11
 */
public class LeetCode206_reverseLinkedList {

    public static void main(String[] args) {
        ListNode node = ListNodeUtil.createNode(1, 2, 3, 4, 5);

        ListNode ans = reverseList1(node);

        System.out.println("ans -> " + ans);
    }

    /**
     * 遍历翻转法
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while(head != null) {
            ListNode cur = head;
            head = head.next;
            cur.next = pre;
            pre = cur;
        }
        return pre;
    }

    /**
     * 递归翻转法
     * Time O（n） 链表遍历了一边从头到尾
     * Space O (n) 递归调用的次数n, 会创建n个方法调用栈
     *
     * 注意要点：
     * 1.递归返回的头节点是之前最后一个元素
     * 2.注意next指针的断开和建立
     * 3.递归的退出条件
     * 4.递归跳出后的处理（指针的翻转）
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

}