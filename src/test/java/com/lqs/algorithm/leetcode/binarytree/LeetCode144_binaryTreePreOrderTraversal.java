package com.lqs.algorithm.leetcode.binarytree;

import com.lqs.algorithm.datastructure.TreeNode;
import com.lqs.algorithm.utils.TreeNodeUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 144 : 二叉树的前序遍历
 * 中->左->右
 *
 * create by lqs
 * date:2024-10-23
 */
public class LeetCode144_binaryTreePreOrderTraversal {


    @Test
    public void test() {
        TreeNode tree = TreeNodeUtil.createTree(1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9);
        System.out.println("original tree -> " + tree);

        List<Integer> ans = preorderTraversal(tree);
        System.out.println("ans -> " + ans);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traversal(root, ans);
        return ans;
    }


    public void traversal(TreeNode node, List<Integer> ans) {

        // exit condition
        if (node == null) return;

        // 中
        ans.add(node.val);
        // 左
        traversal(node.left, ans);
        // 右
        traversal(node.right, ans);
    }

}