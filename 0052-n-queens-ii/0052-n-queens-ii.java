class Solution {
    int count = 0;
    
    public int totalNQueens(int n) {
        int[] queens = new int[n];
        backtrack(queens, 0, n);
        return count;
    }
    
    private void backtrack(int[] queens, int row, int n) {
        if (row == n) {
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(queens, row, col)) {
                queens[row] = col;
                backtrack(queens, row + 1, n);
            }
        }
    }
    
    private boolean isValid(int[] queens, int row, int col) {
        for (int r = 0; r < row; r++) {
            int c = queens[r];
            if (c == col || Math.abs(c - col) == Math.abs(r - row)) return false;
        }
        return true;
    }
}