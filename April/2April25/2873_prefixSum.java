class Solution {
    public long maximumTripletValue(int[] nums) {
        int n= nums.length;
        long maxi=Long.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                long temp= nums[i]-nums[j];
                for(int k=j+1;k<n;k++){
                    maxi= Math.max(maxi,temp*nums[k]);
                }
            }
        }
        return maxi<0?0:maxi;
        
    }
}