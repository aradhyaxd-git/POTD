class Solution {
    public int maxAdjacentDistance(int[] nums) {
        List<Integer> list= new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n+1;i++){
            list.add(nums[i%n]);
        }
        int maxi=Integer.MIN_VALUE;
        for(int i=1;i<list.size();i++){
            maxi= Math.max(maxi,Math.abs(list.get(i-1)-list.get(i))); 
        }
        return maxi;    
    }
}