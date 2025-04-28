class Solution {
    public long countSubarrays(int[] nums, long k) {
        long count=0;
        int n= nums.length;
        int right=0,left=0; 
        long sum=0;
        while(right<n){
            sum += nums[right];
            while(sum*(right-left+1)>=k){ //jaise hi window ka size ke se bada hojaye wese hi shrink kardo window ko
                sum -= nums[left];
                left++;
            }
            count+=(right-left+1);
            right++;
        }
        return count;
        
    }
}