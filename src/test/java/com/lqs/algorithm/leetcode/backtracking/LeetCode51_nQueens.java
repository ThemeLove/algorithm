package com.lqs.algorithm.leetcode.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * N 皇后的规则是：同一行，同一列，同一45度或135度只能有一个皇后，否则会相互攻击
 * create by lqs
 * date:2024-10-15
 */
public class LeetCode51_nQueens {

    @Test
    public void test() {
        List<List<String>> ans = solveNQueens(5);
        System.out.println("ans -> " + ans);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        int[][] chessBoard = new int[n][n];

        backTracking(ans, chessBoard, n, 0);
        return ans;
    }

    public void backTracking(List<List<String>> ans, int[][] chessBoard, int n, int row){
        // exit condition
        if (row >= n) {
            ans.add(convert(chessBoard));
            return;
        }

        // loop
        for (int j = 0; j < n; j++) {
            if (isValid(chessBoard, row, j)) {
                chessBoard[row][j] = 1;
                backTracking(ans, chessBoard, n, row+1);
                chessBoard[row][j] = 0;
            }
        }
    }

    /**
     * check the location queen is valid
     * @param chessBoard
     * @param row
     * @param column
     * @return
     */
    public boolean isValid(int[][] chessBoard, int row, int column) {
        int n = chessBoard.length;
        // 注意这里只需要检查元素上方的元素是否合法，因为皇后是按层放置的，当前元素下方还没有皇后
        // 当前以下行和列的检查还是按照全行和全列，没有进行剪枝
        // 其实check row 可以去掉， 列的检查范围可以缩小到<row
        // check row
        for (int i = 0; i < n; i++) {
            if (i != column && chessBoard[row][i] == 1) return false;
        }
        // check column
        for (int i = 0; i < n; i++) {// i<row
            if (i != row && chessBoard[i][column] == 1) return false;
        }

        // 注意这里只需要检查元素上方的元素是否合法，因为皇后是按层放置的，当前元素下方还没有皇后
        // check 45 degree bevel
        for(int i=row-1, j=column-1; i>=0 && j>=0; i--, j--) {
            if (chessBoard[i][j] == 1) return false;
        }

        // check 135 degree bevel
        for (int i=row-1, j=column+1; i>=0 && j<n; i--, j++) {
            if (chessBoard[i][j] == 1) return false;
        }

        return true;
    }

    public List<String> convert(int[][] chessBoard) {
        List<String> ret = new ArrayList<>();
        int n = chessBoard.length;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(chessBoard[i][j] == 0 ? "." : "Q");
            }
            ret.add(sb.toString());
        }
        return ret;
    }
}