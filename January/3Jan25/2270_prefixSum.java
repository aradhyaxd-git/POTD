class Solution {
    public int waysToSplitArray(int[] nums) {
        int n= nums.length;
        long prefix=0;
        long suffix=0;
        int count=0;
        long totalSum=0;
        for(int num:nums) totalSum+=num;
        for(int i=0;i<n-1;i++){ //n-1 isliye kyuki humko minimum ek non empty chahiye hi, agar n tak jayegi to empty hojayegi
            prefix+=nums[i];
            suffix= totalSum-prefix;
            if(prefix>=suffix) count++;
        }
        return count;

        
    }
}