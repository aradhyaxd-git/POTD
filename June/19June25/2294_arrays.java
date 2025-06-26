class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n= nums.length;
        int count=0,i=0;
        while(i<n){
            int small=nums[i];
            i++;
            while(i<n && nums[i]-small <=k){
                i++;
            }
            count++;

        }
        return count;
        
    }
}