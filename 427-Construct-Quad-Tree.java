 
class Solution {
    public Node construct(int[][] grid) {
        int N = grid.length;
        return helper(grid, 0, N-1, 0, N-1);
    }

    private Node helper(int[][] grid, int rowS, int rowE, int colS, int colE) {
        if (rowS > rowE || colS > colE) {
            return null;
        }

        if (hasAllSameValues(grid, rowS, rowE, colS, colE)) {
            return new Node(grid[rowS][colS] == 1 ? true : false, true);
        } else {
            int rowMid = (rowS + rowE) / 2;
            int colMid = (colS + colE) / 2;
            Node topLeft = helper(grid, rowS, rowMid, colS, colMid);
            Node topRight = helper(grid, rowS, rowMid, colMid+1, colE);
            Node bottomLeft = helper(grid, rowMid+1, rowE, colS, colMid);
            Node bottomRight = helper(grid, rowMid+1, rowE, colMid+1, colE);
            return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }

    private boolean hasAllSameValues(int[][] grid, int rowS, int rowE, int colS, int colE) {
        int val = grid[rowS][colS];
        for (int i=rowS; i<=rowE; i++) {
            for (int j=colS; j<=colE; j++) {
                if (grid[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }
}