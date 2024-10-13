package com.lqs.algorithm.leetcode.linkedlist;


import com.lqs.algorithm.datastructure.ListNode;
import com.lqs.algorithm.datastructure.ListNodeUtil;

/**
 * create by lqs
 * date:2024-10-12
 */
public class LeetCode21_mergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode node1 = ListNodeUtil.createNode(1, 2, 4);
        ListNode node2 = ListNodeUtil.createNode(1, 3, 4);

        ListNode ans = mergeTwoLists1(node1, node2);

        System.out.println("ans -> " + ans);
    }

    /**
     * 本质是双指针法
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // merge the list1 to list2
        ListNode dummy = new ListNode(-1);

        ListNode cur = dummy;

        while(list1 != null) {
            while(list2 != null && list2.val < list1.val) {
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            }
            cur.next = list1;
            cur = cur.next;
            list1 = list1.next;
        }

        cur.next = list2;

        return dummy.next;
    }

    /**
     * 本质是双指针法，容易理解版本
     * Time O(n) n为较长链表的长度
     * Space O(1)
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // merge the list1 to list2
        ListNode dummy = new ListNode(-1);

        ListNode cur = dummy;

        while(list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 == null ? list2 : list1;
        return dummy.next;
    }

    /**
     * 递归解法:不好理解，需要仔细琢磨
     * Time O(n)
     * Space O(n) 因为递归的次数也要占用栈空间
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoList2(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val <= list2.val) {
            list1.next = mergeTwoList2(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoList2(list1, list2.next);
            return list2;
        }
    }

}