package com.lqs.algorithm.leetcode.binarytree;

import com.lqs.algorithm.datastructure.TreeNode;
import com.lqs.algorithm.utils.TreeNodeUtil;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode513 找树左下角的值
 *
 * create by lqs
 * date:2024-10-24
 */
public class LeetCode513_findBottomLeftTreeValue {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.createTree(1, 2);
//        TreeNode root = TreeNodeUtil.createTree(1, 2, 3, 4, null, 5, 6, null, null, 7);
        int ans = findBottomLeftValue(root);
        System.out.println("ans -> " + ans);
    }

    /**
     * 层序遍历，最后一层第一个元素即为答案
     * 最后一层的所有元素都为叶子节点
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        int target = -1;
        List<TreeNode> nodes = new LinkedList<>();
        if (root != null) {
            nodes.add(root);
        }
        while(!nodes.isEmpty()) {
            target = nodes.getFirst().val;
            int size = nodes.size();
            while(size-- > 0) {
                TreeNode node = nodes.removeFirst();
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
        }
        return target;
    }

    @Test
    public void test2() {
//        TreeNode root = TreeNodeUtil.createTree(1, 2);
        TreeNode root = TreeNodeUtil.createTree(1, 2, 3, 4, null, 5, 6, null, null, 7);
        int ans = findBottomLeftValue2(root);
        System.out.println("ans -> " + ans);
    }

    /**
     * 层序遍历，调整每层元素加入顺序，先加入右子树节点，再加入左子树节点，这样最后一层最后一个元素即为答案
     * 即队列中最后一个元素即为答案
     * @param root
     * @return
     */
    public int findBottomLeftValue2(TreeNode root) {
        List<TreeNode> nodes = new LinkedList<>();
        if (root != null) {
            nodes.add(root);
        }
        TreeNode cur = root;
        while(!nodes.isEmpty()) {
            cur = nodes.removeFirst();
            if (cur.right != null) {
                nodes.add(cur.right);
            }
            if (cur.left != null) {
                nodes.add(cur.left);
            }
        }
        return cur.val;
    }

    @Test
    public void test3() {
//        TreeNode root = TreeNodeUtil.createTree(1, 2);
        TreeNode root = TreeNodeUtil.createTree(1, 2);
//        TreeNode root = TreeNodeUtil.createTree(1, 2, 3, 4, null, 5, 6, null, null, 7);
        int ans = findBottomLeftValue3(root);
        System.out.println("ans -> " + ans);
    }

    /**
     * 递归法：逻辑，记录每层的深度，不断更新，同时记录目标数，从左向右遍历（这样同层的第一个元素会先记录）
     * 一般递归法求极值的情况，可能需要定义类成员变量，迭代法一般可以将成员变量定义在局部方法体外
     * @return
     */
    int maxDepth = 0;
    int target = -1;
    public int findBottomLeftValue3(TreeNode root) {
        if (root == null) return -1;
        traversal(root, 1);
        return target;
    }

    public void traversal(TreeNode node, int depth) {
        if (depth > maxDepth) {
            maxDepth = depth;
            target = node.val;
        }
        if (node.left != null) {
            traversal(node.left, depth+1);
        }
        if (node.right != null) {
            traversal(node.right, depth+1);
        }
    }

}