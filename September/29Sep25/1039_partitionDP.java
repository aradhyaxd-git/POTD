class Solution {
    int values[];
    Integer dp[][];
    public int minScoreTriangulation(int[] values) {
        this.values=values; int n= values.length;
        dp= new Integer[n][n];
        return solve(0,values.length-1);
        
    }
    public int solve(int i, int j){
        if(j-i<2) return 0;

        if(dp[i][j]!=null) return dp[i][j];

        int ans=(int)1e9;

        for(int k=i+1;k<j;k++){
            ans= Math.min(ans, values[i]*values[j]*values[k]+ solve(i,k)+ solve(k,j));
        }
        return dp[i][j]=ans;
    }
}