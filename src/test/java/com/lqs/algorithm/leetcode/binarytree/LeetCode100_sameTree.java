package com.lqs.algorithm.leetcode.binarytree;

import com.lqs.algorithm.datastructure.TreeNode;
import com.lqs.algorithm.utils.TreeNodeUtil;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * create by lqs
 * date:2024-10-24
 */
public class LeetCode100_sameTree {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.createTree(1, 2, 2, 3, 4, 4, 3);
        System.out.println("origin root -> " + root);

        TreeNode root2 = TreeNodeUtil.createTree(1, 2, 2, 3, 4, 4, 3);
        System.out.println("origin root2 -> " + root2);

        boolean ans = isSameTree(root, root2);
        System.out.println("ans -> " + ans);
    }

    /**
     * 递归法
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    @Test
    public void test2() {
        TreeNode root = TreeNodeUtil.createTree(1, 2, 2, 3, 4, 4, 3);
        System.out.println("origin root -> " + root);

        TreeNode root2 = TreeNodeUtil.createTree(1, 2, 2, 3, 4, 4, 6);
        System.out.println("origin root2 -> " + root2);

        boolean ans = isSameTree2(root, root2);
        System.out.println("ans -> " + ans);
    }

    /**
     * 栈或队列迭代法
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        List<TreeNode> nodes = new LinkedList<>();
        nodes.add(p);
        nodes.add(q);

        while(!nodes.isEmpty()) {
            // 两两取出
            TreeNode node = nodes.removeFirst();
            TreeNode node2 = nodes.removeFirst();

            if (node == null && node2 == null) continue;
            if (node == null || node2 == null) return false;

            if (node.val != node2.val) return false;

            // 两两添加
            nodes.add(node.left);
            nodes.add(node2.left);

            nodes.add(node.right);
            nodes.add(node2.right);
        }
        return true;
    }


}