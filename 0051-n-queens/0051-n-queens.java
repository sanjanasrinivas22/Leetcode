class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] queens = new int[n]; // queens[row] = col
        backtrack(res, queens, 0, n);
        return res;
    }
    
    private void backtrack(List<List<String>> res, int[] queens, int row, int n) {
        if (row == n) {
            res.add(buildBoard(queens, n));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(queens, row, col)) {
                queens[row] = col;
                backtrack(res, queens, row + 1, n);
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
    
    private List<String> buildBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            char[] rowChars = new char[n];
            Arrays.fill(rowChars, '.');
            rowChars[queens[row]] = 'Q';
            board.add(new String(rowChars));
        }
        return board;
    }
}