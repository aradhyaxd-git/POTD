/*3066. Minimum Operations to Exceed Threshold Value II

You are given a 0-indexed integer array nums, and an integer k.

You are allowed to perform some operations on nums, where in a single operation, you can:

Select the two smallest integers x and y from nums.
Remove x and y from nums.
Insert (min(x, y) * 2 + max(x, y)) at any position in the array.
Note that you can only apply the described operation if nums contains at least two elements.

Return the minimum number of operations needed so that all elements of the array 
are greater than or equal to k. */

class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq= new PriorityQueue<>();
        for(int num: nums) pq.offer((long)num);
        int steps=0;
        while(!pq.isEmpty() && pq.peek()<k){
            long x= pq.poll();
            long y= pq.poll();
            pq.offer(x*2+y);
            steps++;
        }
        return steps;
    }
}
