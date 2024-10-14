package com.lqs.algorithm.leetcode.linkedlist;

import com.lqs.algorithm.datastructure.ListNode;
import com.lqs.algorithm.utils.ListNodeUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * create by lqs
 * date:2024-10-11
 */
public class LeetCode160_intersectionOfTwoLinkedLists {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);


        ListNode node9 = new ListNode(9);


        ListNode headA = ListNodeUtil.createNodeWithNodes(node1, node2, node3, node4, node5);
        ListNode headB = ListNodeUtil.createNodeWithNodes(node9, node3, node4, node5);

        System.out.println("headA -> " + headA);
        System.out.println("headb -> " + headB);

        ListNode ans = getIntersectionNode1(headA, headB);

        System.out.println("ans -> " + ans);
    }

    /**
     * 取巧的方法，不容易想到
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    /**
     * hash 法
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        Set<ListNode> aSets = new HashSet<>();
        while(headA != null) {
            aSets.add(headA);
            headA = headA.next;
        }

        while(headB != null) {
            if (aSets.contains(headB)) {
                return headB;
            } else {
                headB = headB.next;
            }
        }

        return null;
    }


}