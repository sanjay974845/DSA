class Solution {
    private boolean[][] rows = new boolean[9][10];
    private boolean[][] cols = new boolean[9][10];
    private boolean[][] boxes = new boolean[9][10];

    public void solveSudoku(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int digit = board[r][c] - '0';
                    int b = (r / 3) * 3 + (c / 3);
                    rows[r][digit] = true;
                    cols[c][digit] = true;
                    boxes[b][digit] = true;
                }
            }
        }

        solve(board, 0);
    }

    private boolean solve(char[][] board, int position) {
        if (position == 81) {
            return true;
        }

        int r = position / 9;
        int c = position % 9;

        if (board[r][c] != '.') {
            return solve(board, position + 1);
        }

        int b = (r / 3) * 3 + (c / 3);

        for (int digit = 1; digit <= 9; digit++) {
            if (rows[r][digit] || cols[c][digit] || boxes[b][digit]) {
                continue;
            }

            board[r][c] = (char) ('0' + digit);
            rows[r][digit] = true;
            cols[c][digit] = true;
            boxes[b][digit] = true;

            if (solve(board, position + 1)) {
                return true;
            }

            board[r][c] = '.';
            rows[r][digit] = false;
            cols[c][digit] = false;
            boxes[b][digit] = false;
        }

        return false;
    }
}

        
    
