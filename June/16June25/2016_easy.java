/*2016. Maximum Difference Between Increasing Elements

Given a 0-indexed integer array nums of size n, find the maximum difference between nums[i] 
and nums[j] (i.e., nums[j] - nums[i]), such that 0 <= i < j < n and nums[i] < nums[j].

Return the maximum difference. If no such i and j exists, return -1. */


class Solution1 {
    public int maximumDifference(int[] nums) {
        int n= nums.length; int maxDiff=-1;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[j]-nums[i]>0){
                    maxDiff= Math.max(maxDiff,nums[j]-nums[i]);  
                }
            }
        }
        return maxDiff;
    }
}

class Solution {
    public int maximumDifference(int[] nums) {
        int n= nums.length;
        int minSoFar=nums[0];
        int maxDiff=-1;

        for(int i=1;i<n;i++){
            int tempMaxDiff= nums[i]-minSoFar;
            if(nums[i]<minSoFar){
                minSoFar=nums[i];   
            }

            maxDiff= Math.max(maxDiff,tempMaxDiff);
        }
        return maxDiff==0?-1:maxDiff;
    }
}