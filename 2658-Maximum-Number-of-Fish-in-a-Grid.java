class Solution {
    public int findMaxFish(int[][] grid) {
        int ans = 0;
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j] != 0){
                    ans = Math.max(ans,help(grid,i,j));
                }
            }
        }
        return ans;
    }
    public static int help(int[][] grid,int i,int j){
        int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int temp = grid[i][j];
        grid[i][j] = 0;
        int ans1 = 0;

        for(int k =0;k<4;k++){
            int newRow = i+directions[k][0];
            int newCol = j+directions[k][1];
            int temp1 = 0;

            if(isValid(grid,newRow,newCol)){
                temp1 = help(grid,newRow,newCol);
            }
            ans1 += temp1;
            
        }

        return temp+ans1;
    }
    public static boolean isValid(int[][] grid,int i,int j){
        if(i>=grid.length || j>=grid[0].length || j<0 || i<0 || grid[i][j] == 0)return false;
        return true;
    }
}