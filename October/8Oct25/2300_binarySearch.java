class Solution {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n= spells.length;
        int m= potions.length;
        Arrays.sort(potions);
        int ans[]= new int[n];

        for(int i=0;i<n;i++){
             int low=0, high=m-1, idx=m;
             while(low<=high){
                int mid= low+(high-low)/2;

                if((long)spells[i]*potions[mid]>=success){
                    idx=mid;
                    high=mid-1;
                }
                else
                    low=mid+1;
             }
             ans[i]= m-idx;
        }
        return ans;
        
    }
}