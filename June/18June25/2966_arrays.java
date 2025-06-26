public class 2966_arrays {
    public int[][] divideArray(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        List<int[]> result = new ArrayList<>();
        for(int i=0;i<n;i+=3){
            if(nums[i+2]-nums[i]>k){
                return new int[0][0];
            }
            result.add(new int[]{nums[i],nums[i+1],nums[i+2]});
        }
        return result.toArray(new int[result.size()][]);
    }
    
}
