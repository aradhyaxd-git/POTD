class Solution3 {
    Integer dp[][];
    int m;
    public int minimumTotal(List<List<Integer>> triangle) {
        m= triangle.size();
        dp= new Integer[m][m];
       
        return fun(0,0,triangle);
    }
    public int fun(int i,int j,List<List<Integer>> triangle){

        if(i==m-1){
            return triangle.get(m-1).get(j);
        }
        if(dp[i][j]!=null) return dp[i][j];
        int down= triangle.get(i).get(j)+ fun(i+1,j,triangle);
        int diagonal= triangle.get(i).get(j) + fun(i+1,j+1,triangle);
        return dp[i][j]=Math.min(down,diagonal);
    }
}


class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m= triangle.size();
        int dp[][]= new int[m][m];
        for(int j=0;j<m;j++)
            dp[m-1][j]=triangle.get(m-1).get(j); 
        
        for(int i=m-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int down= triangle.get(i).get(j)+ dp[i+1][j];
                int dia= triangle.get(i).get(j)+ dp[i+1][j+1];
                dp[i][j]= Math.min(down,dia); 
            }
        }
        return dp[0][0];
    }
}


class Solution4 {
        public int minimumTotal(List<List<Integer>> triangle) {
            int m= triangle.size();
            int prev[]= new int[m];
            int curr[]= new int[m];
            
            //base case, if i reach the last row i just store this
            for(int j=0;j<m;j++){
                prev[j]=triangle.get(m-1).get(j);
            }
            for(int i=m-2;i>=0;i--){
                for(int j=i;j>=0;j--){
                    int down= triangle.get(i).get(j)+ prev[j];
                    int dia= triangle.get(i).get(j)+ prev[j+1];
                    curr[j]= Math.min(down,dia); 
                }
                prev=curr.clone();
            }
            return prev[0];
        }
    }


    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int m= triangle.size();
            int dp[]= new int[m];
            
            //base case, if i reach the last row i just store this
            for(int j=0;j<m;j++){
                dp[j]=triangle.get(m-1).get(j);
            }
            for(int i=m-2;i>=0;i--){
                for(int j=0;j<=i;j++){
                   dp[j]= triangle.get(i).get(j)+ Math.min(dp[j],dp[j+1]);
                    
                }
                
            }
            return dp[0];
        }
    }
