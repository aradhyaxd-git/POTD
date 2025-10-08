class Solution {
    public int[] avoidFlood(int[] rains) {
        int n= rains.length;
        int ans[]= new int[n];

        Map<Integer,Integer> lastRainMap= new HashMap<>();
        TreeSet<Integer> zeroDay= new TreeSet<>(); 

        //zero days will store the idx of zero
        //lastRain map will store ki, ek particular lake mei last baar barish kab hui thi

        for(int i=0;i<n;i++){
            int lake= rains[i];

            if(lake==0){
                zeroDay.add(i);
                ans[i]=1; // exaample: 69 0 0 69
                            //acc to our approach: -1 69 0 -1
                            //but ans is -1 69 1 -1.. so default value is 1
                            
            }
            else{
                ans[i]= -1;

                if(lastRainMap.containsKey(lake)){
                    int prevRainDayIdx= lastRainMap.get(lake);
                    Integer dryDay= zeroDay.higher(prevRainDayIdx); // treeSet.higher(x)= binary search to find smallest element > x
                    if(dryDay==null)
                        return new int[0];

                    ans[dryDay]=lake;
                    zeroDay.remove(dryDay);
                }
                lastRainMap.put(lake,i);
            }
        }
        return ans;
        
    }
}