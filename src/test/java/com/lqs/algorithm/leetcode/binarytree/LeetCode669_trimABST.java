package com.lqs.algorithm.leetcode.binarytree;

import com.lqs.algorithm.datastructure.TreeNode;
import com.lqs.algorithm.utils.TreeNodeUtil;
import org.junit.Test;

/**
 * LeetCode 669 修剪二叉搜索树
 * create by lqs
 * date:2024-10-27
 */
public class LeetCode669_trimABST {

    @Test
    public void solution() {
        TreeNode root = TreeNodeUtil.createTree(3, 0, 4, null, 2, null, null, 1);

        System.out.println("root -> " + root);

        TreeNode ans = trimBST(root, 1, 3);

        System.out.println("ans -> " + ans);
    }

    /**
     * 递归法:仔细琢磨递归的过程和返回值
     * @param root
     * @param low
     * @param high
     * @return
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        // 退出条件
        if (root == null) return null;
        if (root.val < low) { // 需要删除该元素和所有左子树，但是需要递归处理其右子树（因为右子树都比该元素大）
            return trimBST(root.right, low, high);
        }
        if (root.val > high) { // 需要删除该元素和所有右子树，但是需要递归处理其左子树（因为左子树都比该元素小）
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}