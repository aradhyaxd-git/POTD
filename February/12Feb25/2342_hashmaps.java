/*2342. Max Sum of a Pair With Equal Sum of Digits

You are given a 0-indexed array nums consisting of positive integers. 
You can choose two indices i and j, such that i != j, and the sum of digits 
of the number nums[i] is equal to that of nums[j].

Return the maximum value of nums[i] + nums[j] that you can obtain over all possible 
indices i and j that satisfy the conditions.
If no such pair of indices exists, return -1.

Example 1:

Input: nums = [18,43,36,13,7]
Output: 54
Explanation: The pairs (i, j) that satisfy the conditions are:
- (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 36 = 54.
- (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 7 = 50.
So the maximum sum that we can obtain is 54.

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109 */

//APPROACH 1: MAHA BRUTEFORCE
//approach 2: Self explanatory using hashmaps

class Solution1 {
    public int sumOfDig(int n){
        int sum=0;
        while(n!=0){
            sum+= n%10;
            n/=10;
        }
        return sum;
    }
    public int maximumSum(int[] nums) {
        int n= nums.length;
        HashMap<Integer,Integer> map= new HashMap<>();
        int maxiSum=-1;
        for(int i=0;i<n;i++){
            int sum= sumOfDig(nums[i]);
            if(map.containsKey(sum)){
                maxiSum=Math.max(maxiSum,nums[i]+map.get(sum));
            }
            map.put(sum,Math.max(map.getOrDefault(sum,0),nums[i]));
        }
        return maxiSum;
        
    }
}

//APPROACH 3: OPTIMAL
//-> Since max Sum can be of 999 999 999 = 81, we use array of size 82 [0...81] used as map... SC:O(82)
class Solution {
    public int sumOfDig(int n){
        int sum=0;
        while(n!=0){
            sum+= n%10;
            n/=10;
        }
        return sum;
    }
    public int maximumSum(int[] nums) {
        int n= nums.length;
        int mp[]= new int[82];
        int maxiSum=-1;
        for(int i=0;i<n;i++){
            int sum= sumOfDig(nums[i]);
            if(mp[sum]>0){
                maxiSum=Math.max(maxiSum,nums[i]+mp[sum]);
            }
           mp[sum]= Math.max(mp[sum],nums[i]);
        }
        return maxiSum;
        
    }
}