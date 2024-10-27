package com.lqs.algorithm.leetcode.binarytree;

import com.lqs.algorithm.datastructure.TreeNode;
import com.lqs.algorithm.utils.ArrayUtil;
import com.lqs.algorithm.utils.TreeNodeUtil;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * LeetCode 501:二叉搜索树中的众数
 * create by lqs
 * date:2024-10-26
 */
public class LeetCode501_findModeInBST {

    @Test
    public void solution(){
        TreeNode root = TreeNodeUtil.createTree(1, null, 2, 2);
        int[] ans = findMode(root);

        ArrayUtil.printArr(ans);
    }

    /**
     * 普通做法，适用于所有二叉树
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();

        traversal(root, map);

        System.out.println("map ->" + map);

        Map<Integer, List<Integer>> groupedByValue = map.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())));

        Optional<Integer> first = groupedByValue.keySet().stream().sorted((o1, o2) -> o2.compareTo(o1)).findFirst();

        List<Integer> integers = groupedByValue.get(first.get());
        int[] ans = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            ans[i] = integers.get(i);
        }
        return ans;
    }

    public void traversal(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) return;
        // left
        if (node.left != null) {
            traversal(node.left, map);
        }

        // mid
        Integer count = map.getOrDefault(node.val, 0);
        map.put(node.val, ++count);

        // right
        if (node.right != null) {
            traversal(node.right, map);
        }
    }


    @Test
    public void solutoin2() {
        TreeNode root = TreeNodeUtil.createTree(1, null, 2, 2);
        int[] ans = findMode2(root);

        ArrayUtil.printArr(ans);
    }

    /**
     * 搜索树做法，利用搜索树中序遍历连续性特性，统计计数从而计算众数
     * @param root
     * @return
     */
    int count = 0;
    int maxCount = 0;
    TreeNode pre = null;
    List<Integer> resList = new ArrayList<>();

    public int[] findMode2(TreeNode root) {

        traversal2(root);

        int[] ans = new int[resList.size()];
        for(int i = 0; i < resList.size(); i++) {
            ans[i] = resList.get(i);
        }
        return ans;
    }

    public void traversal2(TreeNode node){
        if (node == null) return;

        // left
        if (node.left != null) {
            traversal2(node.left);
        }

        if (pre == null || pre.val != node.val) {
            count = 1;
        } else {
            count ++;
        }
        pre = node;

        if (count == maxCount) {
            resList.add(node.val);
        }
        if (count > maxCount) {
            maxCount = count;
            resList.clear();
            resList.add(node.val);
        }
        // right
        if (node.right != null) {
            traversal2(node.right);
        }
    }
}