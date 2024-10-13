package com.lqs.algorithm.leetcode.linkedlist;

/**
 * create by lqs
 * date:2024-10-10
 */
public class LeetCode707_designLinked {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        int ele = myLinkedList.get(1);
        System.out.println("ele -> " + ele);

        myLinkedList.deleteAtIndex(1);

        int ele1 = myLinkedList.get(1);
        System.out.println("ele1 -> " + ele1);
    }

    /**
     * 此题中index是从0 开始的，即链表中第1个元素，index = 0
     */
    static class MyLinkedList {
        // add dummyHead as default
        private ListNode dummyHead;
        private int size;

        public MyLinkedList() {
            dummyHead = new ListNode(0);
            size = 0;
        }

        public int get(int index) {
            if (index < 0 || index >= size) return -1;
            ListNode cur = dummyHead;
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index > size) return;
            index = Math.max(0, index); // check index and set default value

            ListNode cur = dummyHead;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            ListNode listNode = new ListNode(val);
            listNode.next = cur.next;
            cur.next = listNode;

            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) return;
            ListNode cur = dummyHead;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;

            size--;
        }

        class ListNode{
            int val;
            ListNode next;
            public ListNode(int val) {
                this.val = val;
            }
        }
    }

    static class MyLinkedList1 {
        // add dummyHead as default
        private ListNode dummyHead;

        public MyLinkedList1() {
            dummyHead = new ListNode(0);
        }

        public int get(int index) {
            int n = 0;
            ListNode cur = dummyHead;
            while(cur.next != null) {
                if (n++ == index) {
                    return cur.next.val;
                }
                cur = cur.next;
            }
            return -1;
        }

        public void addAtHead(int val) {
            ListNode listNode = new ListNode(val);
            listNode.next = dummyHead.next;
            dummyHead.next = listNode;
        }

        public void addAtTail(int val) {
            ListNode cur = dummyHead;
            while(cur.next != null) {
                cur = cur.next;
            }
            cur.next = new ListNode(val);
        }

        public void addAtIndex(int index, int val) {
            ListNode cur = dummyHead;
            int n = 0;
            while(cur.next != null) {
                if (n++ == index) {
                    ListNode listNode = new ListNode(val);
                    listNode.next = cur.next;
                    cur.next = listNode;
                }
                cur = cur.next;
            }
        }

        public void deleteAtIndex(int index) {
            ListNode cur = dummyHead;
            int n = 0;
            while(cur.next != null) {
                if (n++ == index) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }
        }

        class ListNode{
            int val;
            ListNode next;
            public ListNode(int val) {
                this.val = val;
            }
        }
    }

}