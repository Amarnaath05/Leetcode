class Solution {
    
    public int[][] highestPeak(int[][] isWater) {
        int row = isWater.length;
        int col = isWater[0].length;
        int [][] ans = new int[row][col];
        Queue<Pair<Integer , Integer>> q = new LinkedList<>();  
        for(int i=0;i<row ;i++){
            for(int j=0;j<col ;j++){
                if(isWater[i][j] == 1){
                    ans[i][j] =0;
                    q.offer(new Pair(i , j));
                }else{
                    ans[i][j]= -1;
                }
            }
        }
        int[] dir = new int[] {0,1,0,-1,0}; 
        while(q.size()>0){
            Pair<Integer , Integer> p = q.poll();
            int cr = p.getKey() ;  
            int cc = p.getValue(); 
            
            for(int i=0;i<4 ;i++){
                int ncr = cr+dir[i]; int ncc = cc+dir[i+1];   
                if(ncr<0 || ncr>=row || ncc<0 || ncc>= col || ans[ncr][ncc] != -1){
                    continue;
                }
                ans[ncr][ncc] = 1+ ans[cr][cc];
                q.offer(new Pair(ncr , ncc));
            }            
        }
        return ans;
    }
}