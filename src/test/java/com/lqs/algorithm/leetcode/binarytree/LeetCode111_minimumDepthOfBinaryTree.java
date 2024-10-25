package com.lqs.algorithm.leetcode.binarytree;

import com.lqs.algorithm.datastructure.TreeNode;
import com.lqs.algorithm.utils.TreeNodeUtil;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * create by lqs
 * date:2024-10-24
 */
public class LeetCode111_minimumDepthOfBinaryTree {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.createTree(1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9);
        System.out.println("original root -> " + root);

        int ans = minDepth(root);
        System.out.println("ans -> " + ans);
    }

    /**
     * 递归法
     * @param node
     * @return
     */
    public int minDepth(TreeNode node) {
        if (node == null) return 0;
        int height;
        if (node.left == null) {
            height = minDepth(node.right);
        } else if (node.right == null) {
            height = minDepth(node.left);
        } else {
            height = Math.min(minDepth(node.left), minDepth(node.right)); // 左右
        }
        return height + 1; // 中
    }


    @Test
    public void test2() {
        TreeNode root = TreeNodeUtil.createTree(1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9);
        System.out.println("original root -> " + root);

        int ans = minDepth2(root);
        System.out.println("ans -> " + ans);
    }


    /**
     * 参序遍历：
     * 如果当前层有叶子节点即返回当前层的深度。
     * 叶子节点的判断逻辑是：叶子节点的左右子节点都为null
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        int depth = 0;
        while(!nodes.isEmpty()) {
            depth++;
            int size = nodes.size();
            while(size-- > 0) {
                TreeNode node = nodes.removeFirst();
                if (node.left == null && node.right == null) return depth; // 发现第一个叶子节点
                if (node.left != null) nodes.add(node.left);
                if (node.right != null) nodes.add(node.right);
            }
        }
        return depth;
    }

}