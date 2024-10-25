package com.lqs.algorithm.leetcode.binarytree;

import com.lqs.algorithm.datastructure.TreeNode;
import com.lqs.algorithm.utils.TreeNodeUtil;
import org.junit.Test;

/**
 * LeetCode 110 判断二叉树是否是平衡二叉树
 * 平衡二叉树：任何节点的左子树的高度和右子树的高度差<=1
 * create by lqs
 * date:2024-10-24
 */
public class LeetCode110_balancedBinaryTree {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.createTree(1, 2, 3, 4, 5, 6, 7);
        System.out.println("original root ->" + root);

        boolean ans = isBalanced(root);
        System.out.println("ans -> " + ans);
    }

    /**
     * 直接获取根节点的高度，用-1 标记为非平衡二叉树，getHeight >=0 表示是平衡二叉树切获得了高度
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        // leftHeight
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) return -1;

        // rightHeight
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;// 高度差绝对值大于1，非平衡二叉树

        // 当前节点的高度
        return Math.max(leftHeight, rightHeight) + 1;
    }

}