class Solution {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int c=0;
        HashSet<Integer> set= new HashSet<>();
        for(int num:nums) set.add(num);
        for(int num:set){
           if(num>k){
                c++;
            }
            else if(num<k){
                return -1;
            }
        }
        return c;
    }
}