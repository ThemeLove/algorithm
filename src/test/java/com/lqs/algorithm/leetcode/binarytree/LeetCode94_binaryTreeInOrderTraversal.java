package com.lqs.algorithm.leetcode.binarytree;

import com.lqs.algorithm.datastructure.TreeNode;
import com.lqs.algorithm.utils.TreeNodeUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    @Test
    public void test2(){
        TreeNode tree = TreeNodeUtil.createTree(1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9);
        System.out.println("original tree -> " + tree);

        List<Integer> ans = inorderTraversal2(tree);
        System.out.println("ans -> " + ans);
    }

    /**
     * 二叉树 中序 迭代法  普通法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            ans.add(node.val);
            cur = node.right;
        }
        return ans;
    }

    @Test
    public void test3(){
        TreeNode tree = TreeNodeUtil.createTree(1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9);
        System.out.println("original tree -> " + tree);

        List<Integer> ans = inorderTraversal3(tree);
        System.out.println("ans -> " + ans);
    }

    /**
     * 迭代法遍历 通用写法： 本质是标记法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.right != null) stack.push(node.right);
                stack.push(node);
                stack.push(null);
                if (node.left != null) stack.push(node.left);
            } else {
                TreeNode target = stack.pop();
                ans.add(target.val);
            }
        }
        return ans;
    }

}