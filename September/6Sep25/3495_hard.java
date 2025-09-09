class Solution {
    public long minOperations(int[][] queries) {

        long res=0;

        for(int query[]:queries){
            int l= query[0];
            int r= query[1];

            long steps= solve(l,r);

            res+=(steps+1)/2;
        }
        return res;
    }

    public long solve(int l, int r){
        long steps=0;
        long L=1;
        long S=1;

        while(L<=r){
            long R= 4*L-1;
            long start= Math.max(l,L);
            long end= Math.min(r,R);
            if(start<=end){
                steps+= (end-start+1)*S;
            }

            S+=1;
            L=L*4;
        }

        return steps;
    }
}

            
