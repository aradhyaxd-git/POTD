/*416. Partition Equal Subset Sum

Given an integer array nums, return true if you can partition the array into two subsets such that
 the sum of the elements in both subsets is equal or false otherwise.

 

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11]. */


class Solution {
    public boolean canPartition(int[] nums) {
        int n= nums.length; int sum=0;
        for(int num:nums) sum+=num;
        if(sum%2!=0) return false;
        int target= sum/2;
        Boolean[][] dp = new Boolean[n][target+1];
        return solve(nums,0,target,dp);
    }
    public boolean solve(int nums[],int i, int remaining, Boolean dp[][]){
        if(i==nums.length || remaining<0) return false;
        if(remaining==0) return true;
        if(dp[i][remaining]!=null) return dp[i][remaining];

        return dp[i][remaining]=solve(nums,i+1,remaining-nums[i],dp)||solve(nums,i+1,remaining,dp);
    }
}