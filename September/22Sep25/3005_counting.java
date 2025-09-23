class Solution {
    public int maxFrequencyElements(int[] nums) {
        int freq[]= new int[101];
        int maxfrequency=0;
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
            maxfrequency= Math.max(maxfrequency,freq[nums[i]]);
        }
        int result=0;
        for(int i=0;i<101;i++){
            if(freq[i]==maxfrequency){
                result+=maxfrequency;
            }
        }
        return result;
        
    }
}