/*2965. Find Missing and Repeated Values

You are given a 0-indexed 2D integer matrix grid of size n * n with values in 
the range [1, n2]. Each integer appears exactly once except a which appears twice
and b which is missing. The task is to find the repeating and missing numbers a and b.

Return a 0-indexed integer array ans of size 2 where ans[0] equals to a and ans[1] equals to b.

Example 1:

Input: grid = [[1,3],[2,2]]
Output: [2,4]
Explanation: Number 2 is repeated and number 4 is missing so the answer is [2,4]. */

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
      int ans[]= new int[2];
      int n=  grid.length;
      HashSet<Integer> set= new HashSet<>();
      for(int num[]:grid){
        for(int number:num){
          if(set.contains(number)){
            ans[0]=number;   
          }
          set.add(number);
        }
      }
      for(int i=1;i<=n*n;i++){
        if(!set.contains(i)){
          ans[1]=i;
          break;
        }
      }
      return ans;
    }
}