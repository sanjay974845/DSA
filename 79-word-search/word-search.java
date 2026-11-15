class Solution {
    private int m, n;
    private char[][] board;
    private char[] w;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;

        // Pruning 1: board must contain enough of each letter
        int[] boardCount = new int[128];
        for (char[] row : board) {
            for (char ch : row) boardCount[ch]++;
        }
        int[] wordCount = new int[128];
        for (char ch : word.toCharArray()) wordCount[ch]++;
        for (int i = 0; i < 128; i++) {
            if (wordCount[i] > boardCount[i]) return false;
        }

        // Pruning 2: start from the rarer end of the word
        if (boardCount[word.charAt(0)] > boardCount[word.charAt(word.length() - 1)]) {
            word = new StringBuilder(word).reverse().toString();
        }
        this.w = word.toCharArray();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == w[0] && dfs(r, c, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int r, int c, int i) {
        if (i == w.length) return true;
        if (r < 0 || c < 0 || r >= m || c >= n || board[r][c] != w[i]) return false;

        char tmp = board[r][c];
        board[r][c] = '#';          // mark visited in place

        boolean found = dfs(r + 1, c, i + 1)
                     || dfs(r - 1, c, i + 1)
                     || dfs(r, c + 1, i + 1)
                     || dfs(r, c - 1, i + 1);

        board[r][c] = tmp;          // backtrack
        return found;
    }
}

        
    
