package com.lqs.algorithm.leetcode.binarytree;

import com.lqs.algorithm.datastructure.TreeNode;
import com.lqs.algorithm.utils.TreeNodeUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 236 : 二叉树中的最近公共祖先
 * create by lqs
 * date:2024-10-26
 */
public class LeetCode236_lowestCommonAncestorOfABinaryTree {
    @Test
    public void solution() {
        //[3,5,1,6,2,0,8,null,null,7,4]
        TreeNode node = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(4);
        TreeNode root = TreeNodeUtil.createTree(node, node2, node3, node4, node5, node6, node7, null, null, node8, node9);

        TreeNode ans = lowestCommonAncestor(root, node4, node8);

        System.out.println("ans -> " + ans);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return traversal(root, p, q);
    }

    /**
     * 递归法
     * 要仔细琢磨这里返回值的处理，带返回值的递归，要在单层递归逻辑里处理返回值
     * 返回值为null的情况和p 和 q，的合并，null 和 目标node 的合并
     * @param node
     * @param p
     * @param q
     * @return
     */
    public TreeNode traversal(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return null;
        if (node == p) return p;
        if (node == q) return q;
        TreeNode left = traversal(node.left, p, q);
        TreeNode right = traversal(node.right, p, q);
        // 中的处理逻辑
        if (left == null && right == null) return null;
        if (left == null) {
            return right;
        } else if (right == null){
            return left;
        } else {
            return node;
        }
    }
}
