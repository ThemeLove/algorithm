package com.lqs.algorithm.leetcode.array;

import com.lqs.algorithm.utils.ArrayUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * create by lqs
 * date:2024-10-16
 */
public class CommonOperation {

    /**
     * Array 转 List
     */
    @Test
    public void asList() {
        Integer[] nums = {1, 2 ,3};
        List<Integer> list = Arrays.asList(nums);
        System.out.println(list);

        List<Integer> list2 = Arrays.asList(4, 5, 6);
        System.out.println(list2);

        // 注意Arrays.asList 参数为动态数组：T... a
        // 如果数组类型为基本类型，则把数组当成一个整体元素
        int[] nums3 = {7, 8, 9};
        List<int[]> list3 = Arrays.asList(nums3);
        System.out.println(list3);

        String[] strs = {"abc", "def"};
        List<String> list4 = Arrays.asList(strs);
        System.out.println(list4);
    }

    /**
     * List 转 Array
     */
    @Test
    public void toArray() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Integer[] arr = list.toArray(new Integer[0]);
        ArrayUtil.printArr(arr);
    }

    /**
     * Copy 数组
     */
    @Test
    public void arrayCopy() {
        int[] nums = {1, 2, 3};
        int[] copy = new int[3];
        System.arraycopy(nums, 0 , copy, 0, nums.length);
        //  [1,2,3]
        ArrayUtil.printArr(copy);
    }

    /**
     * 范围拷贝 数组
     */
    @Test
    public void copyOfRange() {
        int[] nums = {1, 2, 3, 4, 5};
        int[] copy = Arrays.copyOfRange(nums, 1, 4);
        ArrayUtil.printArr(copy);
    }

    /**
     * 数组填充
     */
    @Test
    public void fillArray() {
        int[] nums = new int[3];
        Arrays.fill(nums, 1);
        //  [1,1,1]
        ArrayUtil.printArr(nums);
    }

    /**
     * 数组排序
     */
    @Test
    public void sortArray() {
        int[] nums = {3, 2 , 1};
        Arrays.sort(nums);
        ArrayUtil.printArr(nums);
    }

    /**
     * 二分查找
     * 当排序数组中有重复元素时，查找的索引是不定的
     */
    @Test
    public void binarySearch() {
        int[] nums = {1, 2, 2, 2, 3, 3, 4, 5};
        int i = Arrays.binarySearch(nums, 2);
        System.out.println(i);
    }

    /**
     * 反转集合元素
     */
    @Test
    public void reverse(){
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('b');
        list.add('c');
        Collections.reverse(list);
        System.out.println(list);
    }
}