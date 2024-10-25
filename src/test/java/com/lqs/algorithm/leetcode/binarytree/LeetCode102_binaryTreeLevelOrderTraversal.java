package com.lqs.algorithm.leetcode.binarytree;

import com.lqs.algorithm.datastructure.TreeNode;
import com.lqs.algorithm.utils.TreeNodeUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.DelayQueue;

/**
 * LeetCode 102 : 二叉树的层序遍历
 * create by lqs
 * date:2024-10-23
 */
public class LeetCode102_binaryTreeLevelOrderTraversal {

    @Test
    public void test() {
        TreeNode tree = TreeNodeUtil.createTree(1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9);
        System.out.println("original tree -> " + tree);
        List<List<Integer>> ans = levelOrder(tree);
        System.out.println("ans -> " + ans);
    }

    /**
     * 按层遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        List<TreeNode> curList = new ArrayList<>();
        curList.add(root);

        while(!curList.isEmpty()) {
            List<TreeNode>  toAddNodes = new ArrayList<>(curList);
            List<Integer> toAddVals = new ArrayList<>();
            for (TreeNode toAddNode : toAddNodes) {
                toAddVals.add(toAddNode.val);
            }
            ans.add(toAddVals);
            curList.clear();
            for(TreeNode node: toAddNodes) {
                if (node.left != null) {
                    curList.add(node.left);
                }
                if (node.right != null) {
                    curList.add(node.right);
                }
            }
        }
        return ans;
    }

    @Test
    public void test2() {
        TreeNode tree = TreeNodeUtil.createTree(1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9);
        System.out.println("original tree -> " + tree);
        List<List<Integer>> ans = levelOrder2(tree);
        System.out.println("ans -> " + ans);
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<TreeNode> nodeList = new ArrayList<>();
        if (root != null) {
            nodeList.add(root);
        }
        int start = 0;
        int size = nodeList.size();

        while(size > 0) {
            int levelSize = 0;
            List<Integer> nodeVals = new ArrayList<>();
            for(int i = start; i < start + size; i++) {
                TreeNode node = nodeList.get(i);
                nodeVals.add(node.val);
                if (node.left != null) {
                    nodeList.add(node.left);
                    levelSize++;
                }
                if (node.right != null) {
                    nodeList.add(node.right);
                    levelSize++;
                }
            }
            start = start + size;
            size = levelSize;
            ans.add(nodeVals);
        }
        return ans;
    }


    @Test
    public void test3() {
        TreeNode tree = TreeNodeUtil.createTree(1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9);
        System.out.println("original tree -> " + tree);
        List<List<Integer>> ans = levelOrder3(tree);
        System.out.println("ans -> " + ans);
    }

    /**
     * 优化方法一
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.addLast(root);
        }

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> nodeVals = new ArrayList<>();
            int i = 1;
            while(i <= size) {
                TreeNode node = queue.pollFirst();
                nodeVals.add(node.val);
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
                i++;
            }
            ans.add(nodeVals);
        }
        return ans;
    }


}