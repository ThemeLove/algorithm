package com.lqs.algorithm.leetcode.binarytree;

import com.lqs.algorithm.datastructure.TreeNode;
import com.lqs.algorithm.utils.TreeNodeUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * LeetCode 257 : 二叉树的所有路径
 * create by lqs
 * date:2024-10-24
 */
public class LeetCode257_binaryTreePaths {

    @Test
    public void test() {
        TreeNode tree = TreeNodeUtil.createTree(1,2,3,null,5);
        System.out.println("original tree -> " + tree);

        List<String> ans = binaryTreePaths(tree); //1, 2, 4, 5, 6, 7, 3, 8, 9
        System.out.println("ans -> " + ans);

    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        getPaths(ans, new ArrayList<>(), root);
        return ans;
    }

    public void getPaths(List<String> ans, List<Integer> path, TreeNode node) {
        path.add(node.val);
        // exit condition
        if (node.left == null && node.right == null) {//叶子节点才收集
            String str = path.stream().map(String::valueOf).collect(Collectors.joining("->"));
            ans.add(str);
            return;
        }

        if(node.left != null) {
            getPaths(ans, path, node.left);
            // back tracking
            path.removeLast();
        }

        if(node.right != null) {
            getPaths(ans, path, node.right);
            // back tracking
            path.removeLast();
        }
    }

/*    @Test
    public void test2() {
        TreeNode tree = TreeNodeUtil.createTree(1,2,3,null,5);
        System.out.println("original tree -> " + tree);

        List<String> ans = binaryTreePaths2(tree); //1, 2, 4, 5, 6, 7, 3, 8, 9
        System.out.println("ans -> " + ans);
    }

    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> ans = new ArrayList<>();
        getPaths2(ans, new StringBuilder(), root);
        return ans;
    }

    public void getPaths2(List<String> ans, StringBuilder path, TreeNode node) {
        path.add(node.val);
        // exit condition
        if (node.left == null && node.right == null) {//叶子节点才收集
            String str = path.stream().map(String::valueOf).collect(Collectors.joining("->"));
            ans.add(str);
            return;
        }

        if(node.left != null) {
            getPaths(ans, path, node.left);
            // back tracking
            path.removeLast();
        }

        if(node.right != null) {
            getPaths(ans, path, node.right);
            // back tracking
            path.removeLast();
        }
    }*/


}