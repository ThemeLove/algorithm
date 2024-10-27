package com.lqs.algorithm.leetcode.binarytree;

import com.lqs.algorithm.datastructure.TreeNode;
import com.lqs.algorithm.utils.TreeNodeUtil;
import org.junit.Test;

/**
 * LeetCode 701 二叉搜索树中的插入
 * create by lqs
 * date:2024-10-27
 */
public class LeetCode701_insertIntoABST {

    @Test
    public void solution() {
//      4,2,7,1,3
        TreeNode root = TreeNodeUtil.createTree(4, 2, 7, 1, 3);
        TreeNode ans = insertIntoBST(root, 5);
        System.out.println("ans -> " + ans);
    }

    /**
     * 解题技巧：二叉搜索树的插入操作，可能有很多解，可以在非叶子节点插入，也可以在叶子节点插入，
     * 但是总是可以在叶子节点找到位置将要插入的数据插入，即叶子节点总是有解的
     *
     * 本解法是放到叶子节点
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // exit condition
        if (root == null) return new TreeNode(val);
        if (root.left == null && root.right == null) { // 到达叶子节点，放置目标元素
            if (root.val > val) {
                root.left = new TreeNode(val);
                return root;
            }
            if (root.val < val) {
                root.right = new TreeNode(val);
                return root;
            }
            return root;
        }
        // traversal
        if (root.val > val) {
             root.left = insertIntoBST(root.left, val);
        } else if(root.val < val) {
             root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}