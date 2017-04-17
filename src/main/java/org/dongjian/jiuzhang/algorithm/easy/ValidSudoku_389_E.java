package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Determine whether a Sudoku is valid.
 * <p>
 * The Sudoku board could be partially filled, where empty cells are filled with the character ..
 * <p>
 * Notice
 * <p>
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */
public class ValidSudoku_389_E {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            int[] map = new int[10];
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (map[board[i][j] - '1'] == 1) {
                    return false;
                }

                map[board[i][j] - '1'] = 1;
            }
        }

        for (int i = 0; i < board.length; i++) {
            int[] map = new int[10];
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (map[board[j][i] - '1'] == 1) {
                    return false;
                }

                map[board[j][i] - '1'] = 1;
            }
        }

        for (int i = 0; i < board.length; i = i + 3) {
            for (int j = 0; j < board.length; j = j + 3) {
                int[] map = new int[9];
                for (int row = i; row < i + 3; row++) {
                    for (int col = j; col < j + 3; col++) {
                        if (board[row][col] == '.') {
                            continue;
                        }
                        if (map[board[row][col] - '1'] == 1) {
                            return false;
                        }
                        map[board[row][col] - '1'] = 1;

                    }
                }
            }
        }

        return true;

    }
}
