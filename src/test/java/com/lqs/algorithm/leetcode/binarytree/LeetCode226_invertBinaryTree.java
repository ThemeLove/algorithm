package com.lqs.algorithm.leetcode.binarytree;

import com.lqs.algorithm.datastructure.TreeNode;
import com.lqs.algorithm.utils.TreeNodeUtil;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode 226 : 翻转二叉树
 * 该题的本质是遍历每一个节点，然后交换左右子节点即可，不论用什么遍历方式都可以
 * create by lqs
 * date:2024-10-24
 */
public class LeetCode226_invertBinaryTree {

    @Test
    public void test() {
        TreeNode tree = TreeNodeUtil.createTree(4, 2, 7, 1, 3, 6, 9);
        System.out.println("original tree ->" + tree);
        TreeNode ans = invertTree(tree);
        System.out.println("ans -> " + ans);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }


    @Test
    public void test2() {
        TreeNode tree = TreeNodeUtil.createTree(4, 2, 7, 1, 3, 6, 9);
        System.out.println("original tree ->" + tree);
        TreeNode ans = invertTree2(tree);
        System.out.println("ans -> " + ans);
    }

    /**
     * 通用迭代法：前中后序都可以
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
                stack.push(node);
                stack.push(null);
            } else {
                TreeNode target = stack.pop();
                TreeNode temp = target.left;
                target.left = target.right;
                target.right = temp;
            }
        }
        return root;
    }

    @Test
    public void test3() {
        TreeNode tree = TreeNodeUtil.createTree(4, 2, 7, 1, 3, 6, 9);
        System.out.println("original tree ->" + tree);
        TreeNode ans = invertTree3(tree);
        System.out.println("ans -> " + ans);
    }

    /**
     * 层序遍历法
     * @param root
     * @return
     */
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) return null;
        List<TreeNode> list = new LinkedList<>();
        list.add(root);
        while(!list.isEmpty()) {
            int size = list.size();
            while(size-- > 0) {
                TreeNode node = list.removeFirst();
                if (node.left != null) list.add(node.left);
                if (node.right != null) list.add(node.right);
                // swap
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
        }
        return root;
    }

}