class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        int[][] pos = new int[m * n + 1][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pos[mat[i][j]] = new int[]{i, j};
            }
        }

        int[] rows = new int[m];
        int[] cols = new int[n];

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int r = pos[num][0]; 
            int c = pos[num][1]; 

            rows[r]++;
            cols[c]++;

            if (rows[r] == n || cols[c] == m) {
                return i;
            }
        }

        return -1; 
    }
}