/*2799. Count Complete Subarrays in an Array

You are given an array nums consisting of positive integers.

We call a subarray of an array complete if the following condition is satisfied:

The number of distinct elements in the subarray is equal to the number of distinct elements in the
whole array.
Return the number of complete subarrays.

A subarray is a contiguous non-empty part of an array.

  */
  class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n= nums.length;
        int right=0,left=0;
        HashSet<Integer> wholeSum= new HashSet<>();
        for(int num:nums) wholeSum.add(num);

        int count=0;
        HashMap<Integer,Integer> map= new HashMap<>();
        while(right<n){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.size()==wholeSum.size() && right<n && left<n){
                int freq= map.get(nums[left]);
                count+= (n-right);
                map.put(nums[left],map.getOrDefault(nums[left],0)-1);
                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                }
                left++;
            }
            right++;
        }
        return count;
        
    }
}