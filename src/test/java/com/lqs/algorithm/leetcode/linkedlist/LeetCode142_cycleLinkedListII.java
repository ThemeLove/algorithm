package com.lqs.algorithm.leetcode.linkedlist;

import com.lqs.algorithm.datastructure.ListNode;
import com.lqs.algorithm.utils.ListNodeUtil;

import java.util.HashSet;
import java.util.Set;
/**
 * 环形链表II
 * create by lqs
 * date:2024-10-11
 */
public class LeetCode142_cycleLinkedListII {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        ListNode head = ListNodeUtil.createNodeWithNodes(node1, node2, node3, node4, node5, node3);

        ListNode ans = detectCycle2(head);

        if (ans == null) {
            System.out.println("ans is null");
        } else {
            System.out.println("ans -> " + ans.val);
        }
    }

    /**
     * hash 法，
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        Set<ListNode> sets = new HashSet<>();
        while(head != null) {
            if (!sets.add(head)) return head;
            sets.add(head);
            head = head.next;
        }
        return null;
    }

    /**
     * link:https://www.bilibili.com/video/BV1if4y1d7ob/?spm_id_from=333.337.search-card.all.click&vd_source=b859174ae70e495ba11b3c433be2a7ee
     * 双指针法
     * @param head
     * @return
     */
    public static ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                while(slow != head) {
                    slow = slow.next;
                    head = head.next;
                }
                return slow;
            }
        }

        return null;
    }

}