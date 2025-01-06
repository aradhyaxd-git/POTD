//APPROACH 1 : BRUTEFORCE

class Solution1 {
    public int[] minOperations(String boxes) {
        int n= boxes.length();
        char x[]= boxes.toCharArray();
        int ans[]= new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(x[j]=='1'){
                    ans[i]+= Math.abs(i-j);
                }
            }
        }
        return ans;
        
    }
}
/*OPTIMAL APPROACH: 2 PASS PREFIX SUM */
class Solution {
    public int[] minOperations(String boxes) {
        int n= boxes.length();
        int cumValue=0,cumValueSum=0;
        //
        int ans[]= new int[n];
        //LEFT TO RIGHT PASS
        for(int i=0;i<n;i++){
            ans[i]+=cumValueSum;
            cumValue+= boxes.charAt(i)=='0'?0:1;
            cumValueSum+=cumValue;
        }
        cumValue=0;
        cumValueSum=0;
        //RIGHT TO LEFT PASS
        for(int i=n-1;i>=0;i--){
            ans[i]+=cumValueSum;
            cumValue+= boxes.charAt(i)=='0'?0:1;
            cumValueSum+=cumValue;
        }
        return ans; 
    }
}