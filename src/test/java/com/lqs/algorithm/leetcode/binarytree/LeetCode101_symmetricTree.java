package com.lqs.algorithm.leetcode.binarytree;

import com.lqs.algorithm.datastructure.TreeNode;
import com.lqs.algorithm.utils.TreeNodeUtil;
import org.junit.Test;

import java.util.Stack;

/**
 * create by lqs
 * date:2024-10-24
 */
public class LeetCode101_symmetricTree {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.createTree(1, 2, 2, 3, 4, 4, 3);
        System.out.println("origin tree -> " + root);

        boolean ans = isSymmetric(root);
        System.out.println("ans -> " + ans);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricTree(root.left, root.right);
    }

    public boolean isSymmetricTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null) return false;
        if (right == null) return false;
        if (left.val != right.val) return false;
        boolean out = isSymmetricTree(left.left, right.right); // 左
        boolean inner = isSymmetricTree(left.right, right.left);// 右
        return out && inner; // 中
    }

    @Test
    public void test2() {
        TreeNode root = TreeNodeUtil.createTree(1, 2, 2, 3, 4, 4, 3);
        System.out.println("origin tree -> " + root);

        boolean ans = isSymmetric2(root);
        System.out.println("ans -> " + ans);
    }

    /**
     * 栈 或 队列 迭代解法
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while(!stack.isEmpty()) {
            // 两两一组进行比较
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();

            // 不满足的情况先返回
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;

            // 两两一组进行加入
            stack.push(left.left);
            stack.push(right.right);

            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }
}