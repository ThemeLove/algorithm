package com.lqs.algorithm.leetcode.binarytree;

import com.lqs.algorithm.datastructure.TreeNode;
import com.lqs.algorithm.utils.TreeNodeUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 94 : 二叉树的中序遍历
 * 左->中->右
 * create by lqs
 * date:2024-10-23
 */
public class LeetCode94_binaryTreeInOrderTraversal {

    @Test
    public void test() {
        TreeNode tree = TreeNodeUtil.createTree(1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9);
        System.out.println("original tree -> " + tree);

        List<Integer> ans = inorderTraversal(tree);
        System.out.println("ans -> " + ans);
    }

    public List<Integer> inorderTraversal(TreeNode tree) {
        List<Integer> ans = new ArrayList<>();
        traversal(tree, ans);
        return ans;
    }

    public void traversal(TreeNode node, List<Integer> ans) {
        // exit condition
        if (node == null) return;

        // left
        traversal(node.left, ans);
        // mid
        ans.add(node.val);
        // right
        traversal(node.right, ans);
    }

}