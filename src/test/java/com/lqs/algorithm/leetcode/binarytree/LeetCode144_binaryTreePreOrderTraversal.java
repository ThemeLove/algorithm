package com.lqs.algorithm.leetcode.binarytree;

import com.lqs.algorithm.datastructure.TreeNode;
import com.lqs.algorithm.utils.TreeNodeUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

        List<Integer> ans = preorderTraversal(tree); //1, 2, 4, 5, 6, 7, 3, 8, 9
        System.out.println("ans -> " + ans);
    }

    /**
     * 递归法 前序遍历二叉树
     * @param root
     * @return
     */
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


    @Test
    public void test2() {
        TreeNode tree = TreeNodeUtil.createTree(1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9);
        System.out.println("original tree -> " + tree);

        List<Integer> ans = preorderTraversal2(tree);
        System.out.println("ans -> " + ans);
    }

    /**
     * 迭代法 前序遍历二叉树， 普通法
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.right != null) stack.add(node.right);
            if (node.left != null) stack.add(node.left);
        }
        //1, 2, 4, 5, 6, 7, 3, 8, 9
        return ans;
    }

    @Test
    public void test3() {
        TreeNode tree = TreeNodeUtil.createTree(1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9);
        System.out.println("original tree -> " + tree);

        List<Integer> ans = preorderTraversal3(tree);
        System.out.println("ans -> " + ans);
    }

    /**
     * 二叉树 迭代遍历通用写法: 本质是标记法
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.right != null) stack.push(node.right); // 右
                if (node.left != null) stack.push(node.left); // 左
                stack.push(node); // 中
                stack.push(null);
            } else {
                TreeNode target = stack.pop();
                ans.add(target.val);
            }
        }
        return ans;
    }

}