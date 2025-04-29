class Solution {
    public long countSubarrays(int[] nums, int k) {
        long count=0;
        int right=0,left=0;
        int maxi=Arrays.stream(nums).max().getAsInt();
        long countMaxi=0;
        int n= nums.length;
        while(right<n){
            if(nums[right]==maxi){
                countMaxi++;
            }
            while(countMaxi>=k){
                if(nums[left]==maxi && left<n){
                    countMaxi--;
                }
                left++;
            }
            count+=left;
            right++;
        }
        return count;
    }
}