package com.lqs.algorithm.leetcode.binarytree;

import com.lqs.algorithm.datastructure.TreeNode;
import com.lqs.algorithm.utils.TreeNodeUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode 145 : 二叉树的后序遍历
 * 左->右->中
 * create by lqs
 * date:2024-10-23
 */
public class LeetCode145_binaryTreePostOrderTravelsal {

    @Test
    public void test() {
        TreeNode tree = TreeNodeUtil.createTree(1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9);

        System.out.println("original tree -> " + tree);

        List<Integer> ans = postorderTraversal(tree);
        System.out.println("ans -> " + ans);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traversal(root, ans);
        return ans;
    }

    public void traversal(TreeNode node, List<Integer> ans) {
        // exit condition
        if (node == null) return;

        // 左
        traversal(node.left, ans);
        // 右
        traversal(node.right, ans);
        // 中
        ans.add(node.val);
    }

    @Test
    public void test2() {
        TreeNode tree = TreeNodeUtil.createTree(1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9);
        System.out.println("original tree -> " + tree);
        List<Integer> ans = postorderTraversal22(tree); //4, 6, 7, 5, 2, 9, 8, 3, 1
        System.out.println("ans -> " + ans);
    }

    /**
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) stack.add(node.left);
            ans.add(0, node.val); // 4, 6, 7, 5, 2, 9, 8, 3, 1
            if (node.right != null) stack.add(node.right);
        }
        return ans;
    }

    /**
     * 先前序遍历，后将结果反转
     * 代码前序迭代法差不多，演变而来
     * 前序（中左右） -> 中右左 ->反转->左右中(后序遍历)
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal22(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val); // 4, 6, 7, 5, 2, 9, 8, 3, 1
            if (node.left != null) stack.add(node.left);
            if (node.right != null) stack.add(node.right);
        }
        // 先前序遍历后将结果反转
        //1, 2, 4, 5, 6, 7, 3, 8, 9
        // [1, 3, 8, 9, 2, 5, 7, 6, 4] -> [4, 6, 7, 5, 2, 9, 8, 3, 1]
        ans = ans.reversed();
        return ans;
    }



    @Test
    public void test3(){
        TreeNode tree = TreeNodeUtil.createTree(1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9);
        System.out.println("original tree -> " + tree);
        List<Integer> ans = postorderTraversal3(tree);
        System.out.println("ans -> " + ans);
    }

    /**
     * 二叉树 后序迭代 通用法
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                stack.push(node);
                stack.push(null);// 标记
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            } else {
                TreeNode target = stack.pop();
                ans.add(target.val);
            }
        }
        return ans;
    }
}