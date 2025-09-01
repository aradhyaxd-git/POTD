class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n= nums.length;
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->b[0]-a[0]);

        for(int i=0;i<n;i++){
            pq.offer(new int[]{nums[i],i});
        }

        List<int[]> list= new ArrayList<>();
        
        for(int i=0;i<k;i++){
            list.add(pq.poll());
        }

        list.sort((a,b)->a[1]-b[1]);

        int res[]= new int[k];
        for(int i=0;i<k;i++){
            res[i]= list.get(i)[0];
        }
        
        return res;
    }
}