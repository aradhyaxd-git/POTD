/*1863. Sum of All Subset XOR Totals
Solved
Easy
Topics
Companies
Hint
The XOR total of an array is defined as the bitwise XOR of all its elements, or 0 if the array is empty.

For example, the XOR total of the array [2,5,6] is 2 XOR 5 XOR 6 = 1.
Given an array nums, return the sum of all XOR totals for every subset of nums. 

Note: Subsets with the same elements should be counted multiple times.

An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b. */

class Solution {
    public void generateSubsets(int nums[],int index, List<Integer> current, List<List<Integer>> subset){
        if(index==nums.length){
            subset.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        generateSubsets(nums,index+1,current,subset);
        current.remove(current.size()-1);
        generateSubsets(nums,index+1,current,subset);
    }
    public int subsetXORSum(int[] nums) {
        List<List<Integer>> subsets= new ArrayList<>();
        generateSubsets(nums,0,new ArrayList<>(),subsets);
        int totalSum=0;
        for(List<Integer> sub:subsets){
            int currentXor=0;
            for(int num:sub){
                currentXor^=num;
            }
            totalSum+=currentXor;
        }
        return totalSum;
        
        
    }
}