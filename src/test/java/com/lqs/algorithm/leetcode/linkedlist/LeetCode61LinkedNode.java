package com.lqs.algorithm.leetcode.linkedlist;

public class LeetCode61LinkedNode {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public void printNode() {
            StringBuffer sb = new StringBuffer();
            sb.append(val);
            ListNode next = this.next;
            while(next!=null) {
                sb.append("->");
                sb.append(next.val);
                next = next.next;
            }
            sb.append("->null");
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        ListNode sixNode = new ListNode(6);
        ListNode fiveNode = new ListNode(5,sixNode);
        ListNode fourNode = new ListNode(4, fiveNode);
        ListNode threeNOde = new ListNode(3, fourNode);
        ListNode twoNode = new ListNode(2, threeNOde);
        ListNode oneNode = new ListNode(1, twoNode);
        oneNode.printNode();
//        ListNode oneNodeResult = rotateRight(oneNode);


        ListNode onlyOneNode = new ListNode(1);
        ListNode onlyOneNOdeStep = rotateRight(oneNode, 3);
        onlyOneNOdeStep.printNode();




//        ListNode newListNode1Step = rotateRight(oneNode, 1);
//        newListNode1Step.printNode();
//        ListNode newListNodeTwoStep = rotateRight(oneNode, 3);
//        newListNodeTwoStep.printNode();
//        ListNode newListNodeThreeStep = rotateRight(oneNode, 3);
//        newListNodeThreeStep.printNode();
//        ListNode newListNodeForStep = rotateRight(oneNode, 4);
//        newListNodeForStep.printNode();
    }

    public static  ListNode rotateRight(ListNode head, int k) {
        int size = getSize(head);
        if (size==0) return head;
        k = k%size;
        int moveStep = 0;
        while (head!=null && head.next!=null&& moveStep < k) {
            head = moveOneStep(head);
            moveStep++;
        }
        return head;
    }

    public static int getSize(ListNode head) {
        int size = 0;
        while(head!=null){
            ++size;
            head=head.next;
        }
        return size;
    }

    public static ListNode moveOneStep(ListNode head) {
//      ListNode firstNode = head;
        ListNode lastSecondNode = head;
        ListNode lastNode = lastSecondNode.next;
        while(lastNode.next!=null) {
            lastSecondNode = lastNode;
            lastNode = lastNode.next;
        }
        lastNode.next = head;
        lastSecondNode.next = null;
        return lastNode;
    }
}
