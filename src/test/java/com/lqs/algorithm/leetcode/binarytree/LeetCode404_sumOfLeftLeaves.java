package com.lqs.algorithm.leetcode.binarytree;

import com.lqs.algorithm.datastructure.TreeNode;
import com.lqs.algorithm.utils.TreeNodeUtil;
import org.junit.Test;

/**
 * LeetCode 404 : 左叶子之和
 * create by lqs
 * date:2024-10-24
 */
public class LeetCode404_sumOfLeftLeaves {

    @Test
    public void test() {
        TreeNode tree = TreeNodeUtil.createTree(3,9,20,null,null,15,7);
//        TreeNode tree = TreeNodeUtil.createTree(1);
        System.out.println("original tree -> " + tree);

        int ans = sumOfLeftLeaves(tree); //1, 2, 4, 5, 6, 7, 3, 8, 9
        System.out.println("ans -> " + ans);
    }

    public int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return sum;
        sum(root, false);
        return sum;
    }

    public void sum(TreeNode node, boolean isLeft) {
        if (node.left == null && node.right == null && isLeft) {//叶子节点
            sum += node.val;
            return;
        }
        if (node.left != null) {
            sum(node.left, true);
        }

        if (node.right != null) {
            sum(node.right, false);
        }
    }


    @Test
    public void test2() {
//        TreeNode tree = TreeNodeUtil.createTree(3,9,20,null,null,15,7);
        TreeNode tree = TreeNodeUtil.createTree(1,2);
        System.out.println("original tree -> " + tree);

        int ans = sumOfLeftLeaves2(tree); //1, 2, 4, 5, 6, 7, 3, 8, 9
        System.out.println("ans -> " + ans);
    }

    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) return 0;
        return sumLeft(root, false);
    }

    public int sumLeft(TreeNode node, boolean isLeft) {
        if (node.left == null && node.right == null) {//叶子节点
            return isLeft ? node.val : 0;
        }
        int leftSum = 0;
        if (node.left != null) {
           leftSum = sumLeft(node.left, true);
        }
        int rightSum = 0;
        if (node.right != null) {
            rightSum =sumLeft(node.right, false);
        }
        return leftSum + rightSum;
    }


}