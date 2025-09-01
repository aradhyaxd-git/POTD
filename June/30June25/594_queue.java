class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int n= nums.length;
        Queue<Integer> q= new LinkedList<>();
        int maxLen=0;

        for(int i=0;i<n;i++){
            while(!q.isEmpty() && nums[i]-q.peek() > 1){
                q.poll();
            }

            q.offer(nums[i]);

            if(nums[i]-q.peek()==1){
                maxLen= Math.max(maxLen,q.size());
            }
        }
        return maxLen;
    }
}