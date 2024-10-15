package com.lqs.algorithm.leetcode.backtracking;

import com.lqs.algorithm.utils.ArrayUtil;
import org.junit.Test;

/**
 * create by lqs
 * date:2024-10-15
 */
public class LeetCode37_sudukuSolver {

    @Test
    public void solution() {
        char[][] board =
                    {
                        {'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}
                    };

        solveSudoku(board);

        ArrayUtil.printMetrix(board);
    }

    public void solveSudoku(char[][] board) {
        backTracking(board);
    }

    public boolean backTracking(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(board, i, j, k)){
                            board[i][j] = k;
                            if(backTracking(board)){
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int row, int col, char check){
        // check row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == check) return false;
        }

        // check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == check) return false;
        }
        // check sub-box
        // question? how to identify sub-box scope with row, col ?

        int rowStart = (row/3) * 3;
        int colStart = (col/3) * 3;

        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3 ; j++) {
                if (board[i][j] == check) return false;
            }
        }

        return true;
    }

}