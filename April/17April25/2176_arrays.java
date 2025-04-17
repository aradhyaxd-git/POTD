/*2176. Count Equal and Divisible Pairs in an Array

Given a 0-indexed integer array nums of length n and an integer k, return the number of pairs 
(i, j) where 0 <= i < j < n, such that nums[i] == nums[j] and (i * j) is divisible by k. */

class Solution {
    public int countPairs(int[] nums, int k) {
        int count=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if((i*j)%k==0){
                    if(nums[i]==nums[j]) count++;
                }
            }
        }
        return count;

        
    }
}