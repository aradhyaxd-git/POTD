class Solution {
    int n;
    int directions[][]={{0,1},{-1,0},{1,0},{0,-1}};
    public boolean isValid(int i, int j){
        return i>=0 && j>=0 && i<n && j<n;
    }
    public int swimInWater(int[][] grid) {
        n= grid.length;

        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[0]-b[0]);

        boolean visited[][]= new boolean[n][n];
        pq.offer(new int[]{grid[0][0],0,0});


        while(!pq.isEmpty()){
            int curr[]= pq.poll();
            int time=curr[0],i=curr[1],j=curr[2];

            if(i==n-1 && j==n-1) return time;

            if(visited[i][j]) continue;

            visited[i][j]=true;

            for(int dir[]:directions){
                int i_= i+dir[0];
                int j_= j+dir[1];

                if(isValid(i_,j_) && !visited[i_][j_]){
                    pq.offer(new int[]{Math.max(time,grid[i_][j_]),i_,j_});
                }
            }
        }
        return -1;

        
    }
}