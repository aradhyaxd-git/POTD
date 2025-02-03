class Solution {
    public int longestMonotonicSubarray(int[] nums) {
     int maxi=0; int n= nums.length;
     if(n==1) return 1;
     int count=1;
        for(int i=0;i<n-1;i++){
            if(nums[i]>nums[i+1]  )
                count++;
            else count=1;
            maxi= Math.max(maxi,count);
        }
        count=1;
        for(int i=0;i<n-1;i++){
            if(nums[i]<nums[i+1])
                count++;
            else count=1;
            maxi= Math.max(maxi,count);
        }
        return maxi;
    }
}