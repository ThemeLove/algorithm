package com.lqs.algorithm.leetcode.binarytree;

import com.lqs.algorithm.datastructure.TreeNode;
import com.lqs.algorithm.utils.TreeNodeUtil;
import org.junit.Test;

/**
 * LeetCode 112 路径总和
 * create by lqs
 * date:2024-10-25
 */
public class LeetCode112_pathSum {

    @Test
    public void solution() {
        TreeNode root = TreeNodeUtil.createTree(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1);
        boolean ans = hasPathSum(root, 22);
        System.out.println("ans -> " + ans);
    }

    /**
     * 递归法
     * 技巧，每访问一个元素，减去当前元素的值，如果是叶子节点的话，判断叶子节点的值是否和剩余目标值相等，如果相等则有解，直接return true
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum){
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    @Test
    public void solution2() {
        TreeNode root = TreeNodeUtil.createTree(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1);
        boolean ans = hasPathSum2(root, 22);
        System.out.println("ans -> " + ans);
    }

    /**
     * 正向思维：递归思路：累加路径和 和 targetSum 比较
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum2(TreeNode root, int targetSum){
        if (root == null) return false;
        return hasPathSum2(root, 0, targetSum);
    }

    public boolean hasPathSum2(TreeNode node, int sum, int targetSum) {
        // exit condition
        if (node.left == null && node.right == null) {
            return sum + node.val == targetSum;
        }
        // left
        if (node.left != null) {
            boolean leftRet = hasPathSum2(node.left, sum+node.val, targetSum);
            if(leftRet) return true;
        }
        // right
        if (node.right != null) {
            boolean rightRet = hasPathSum2(node.right, sum+node.val, targetSum);
            if (rightRet) return true;
        }
        return false;
    }

}