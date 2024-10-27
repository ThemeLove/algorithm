package com.lqs.algorithm.leetcode.binarytree;

import com.lqs.algorithm.datastructure.TreeNode;
import com.lqs.algorithm.utils.TreeNodeUtil;
import org.junit.Test;

/**
 * LeetCode 700 ：二叉搜索树中搜索
 * 搜索树特点：父节点大于所有左子树节点，小于所有右子树节点
 * create by lqs
 * date:2024-10-26
 */
public class LeetCode700_searchInABinarySearchTree {

    @Test
    public void solution() {
        TreeNode root = TreeNodeUtil.createTree(4, 2, 7, 1, 3);
        TreeNode ans = searchBST(root, 2);
        System.out.println("ans -> " + ans);
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

}