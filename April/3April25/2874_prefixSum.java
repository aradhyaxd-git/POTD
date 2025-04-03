class Solution {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;
        int[] maxSuffix= new int[n];
        maxSuffix[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            maxSuffix[i]=Math.max(nums[i],maxSuffix[i+1]);
        }
        int prefixMax[]= new int[n];
        prefixMax[0]=nums[0];
       
        for(int i=1;i<n;i++){
            prefixMax[i]=Math.max(nums[i],prefixMax[i-1]);
        }
        long sum=0;
        for(int j=1;j<n-1;j++){
            long temp=(long)(prefixMax[j-1]-nums[j])*maxSuffix[j+1];
            sum= Math.max(sum,temp);
        }
        return sum;
        
    }
}