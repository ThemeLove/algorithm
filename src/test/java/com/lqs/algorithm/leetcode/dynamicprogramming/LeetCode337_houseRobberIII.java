package com.lqs.algorithm.leetcode.dynamicprogramming;

import com.lqs.algorithm.datastructure.TreeNode;
import com.lqs.algorithm.utils.TreeNodeUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode317 打家劫舍III
 * create by lqs
 * date:2024-11-06
 */
public class LeetCode337_houseRobberIII {

    @Test
    public void solution() {
        TreeNode root = TreeNodeUtil.createTree(3, 2, 3, null, 3, null, 1);
        int ans = rob(root);
        System.out.println("ans -> " + ans);
    }

    /**
     * 树形dp:动态规划解法
     * 定义一个长度为2的一维数组new int dp[2];
     * dp[0] 表示偷当前节点时获取的最大价值 = currentNode.val + 不偷左孩子节点时的最大价值 + 不偷右孩子节点时的最大价值
     * dp[1] 表示不偷当前节点时获取的最大价值 = 左孩子的最大价值 + 右孩子的最大价值
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        int[] dp = robInternal(root);
        return Math.max(dp[0], dp[1]);
    }

    /**
     * 动态规划解法
     * @param node
     * @return
     */
    public int[] robInternal(TreeNode node) {
        int[] dp = new int[2];
        if (node == null) return dp;

        // left
        int[] left = robInternal(node.left);
        // right
        int[] right = robInternal(node.right);

        // mid
        // not rob
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        // rob
        dp[1] = node.val + left[0] + right[0];

        return dp;
    }

    @Test
    public void solution2() {
        TreeNode root = TreeNodeUtil.createTree(3, 2, 3, null, 3, null, 1);
        int ans = rob2(root);
        System.out.println("ans -> " + ans);
    }

    /**
     * 递归暴力解法
     *
     * 思路：对于单个节点的考虑能偷的最大钱数
     * 当前节点为爷爷，左右节点为儿子，在下层为4个孙子
     *
     * 偷当前节点时最大钱数：current.val + 4 个孙子的val
     * 不偷当前节点时最大钱数：2个儿子的最大钱数
     * @param root
     * @return
     */
    public int rob2(TreeNode root) {
        if (root == null) return 0;

        // 考虑偷当前节点时
        int maxMoney = root.val;
        if (root.left != null) {
            maxMoney += (rob(root.left.left) + rob(root.left.right));
        }
        if (root.right != null) {
            maxMoney += (rob(root.right.left) + rob(root.right.right));
        }
        // 不偷当前节点是
        // rob(root.left) + rob(root.right)
        return Math.max(maxMoney, rob(root.left) + rob(root.right));
    }

    /**
     * 记忆化递归，空间换时间
     */
    @Test
    public void solution3() {
        TreeNode root = TreeNodeUtil.createTree(3, 2, 3, null, 3, null, 1);
        Map<TreeNode, Integer> map = new HashMap<>();
        int ans = rob3(root, map);
        System.out.println("ans -> " + ans);
    }

    public int rob3(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        // 考虑偷当前节点时
        int maxMoney = root.val;
        if (root.left != null) {
            maxMoney += (rob3(root.left.left, map) + rob3(root.left.right, map));
        }
        if (root.right != null) {
            maxMoney += (rob3(root.right.left, map) + rob3(root.right.right, map));
        }
        // 不偷当前节点是
        // rob(root.left) + rob(root.right)
        int max = Math.max(maxMoney, rob3(root.left, map) + rob3(root.right, map));
        map.put(root, max);
        return max;
    }

}