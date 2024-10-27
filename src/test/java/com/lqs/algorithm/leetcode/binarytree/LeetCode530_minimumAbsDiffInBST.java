package com.lqs.algorithm.leetcode.binarytree;

import com.lqs.algorithm.datastructure.TreeNode;
import com.lqs.algorithm.utils.TreeNodeUtil;
import org.junit.Test;

/**
 * LeetCode530 ： 二叉搜索树的最小绝对差
 * 和LeetCode98 解题思路一样
 * create by lqs
 * date:2024-10-26
 */
public class LeetCode530_minimumAbsDiffInBST {

    @Test
    public void solution() {

        TreeNode root = TreeNodeUtil.createTree(4, 2, 6, 1, 3);

        int ans = getMinimumDifference(root);

        System.out.println("ans -> " + ans);
    }

    /**
     * 中序遍历
     */
    int minDiff = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return minDiff;
    }

    public void traversal(TreeNode node) {
        if (node == null) return;
        // left
        if (node.left != null) {
            traversal(node.left);
        }
        // mid
        if (pre != null){
            minDiff = Math.min(node.val - pre.val, minDiff);
        }
        // right
        pre = node;

        if (node.right != null) {
            traversal(node.right);
        }
    }
}