package com.lqs.algorithm.leetcode.binarytree;

import com.lqs.algorithm.datastructure.TreeNode;
import com.lqs.algorithm.utils.TreeNodeUtil;
import org.junit.Test;

import java.util.Stack;

/**
 * create by lqs
 * date:2024-10-27
 */
public class LeetCode538_convertBSTToGreaterTree {

    @Test
    public void solution() {
        // [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
        TreeNode root = TreeNodeUtil.createTree(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8);

        TreeNode ans = convertBST(root);

        System.out.println("ans -> " + ans);
    }


    /**
     * 题解：平衡二叉树中序遍历后得到从小到大的序列，中序遍历为（左中右）
     * 所以如果按照 右中左遍历的话得到从大到小的序列
     * 这样用双指针做法在递归中就很容易累加节点的值
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        traversal(root);
        return root;
    }

    int preSum = 0;
    public void traversal(TreeNode node) {
        if (node == null) return;
        traversal(node.right);
        node.val += preSum;
        preSum = node.val;
        traversal(node.left);
    }

    @Test
    public void solution2() {
        // [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
        TreeNode root = TreeNodeUtil.createTree(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8);
        TreeNode ans = convertBST2(root);
        System.out.println("ans -> " + ans);
    }

    /**
     * 右中左 迭代法
     * @param root
     * @return
     */
    int preSum2 = 0;
    public TreeNode convertBST2(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            TreeNode node = stack.pop();
            node.val = node.val + preSum2;
            preSum2 = node.val;
            cur = node.left;
        }
        return root;
    }

}