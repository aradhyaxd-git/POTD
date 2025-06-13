class Solution {
    public int getState(int countA, int countB){
        int parityA= countA%2;
        int parityB= countB%2;

        if(parityA==0 && parityB==0) return 0;
        if(parityA==0 && parityB==1) return 1;
        if(parityA==1 && parityB==0) return 2;
        return 3;
        
    }
    public int maxDifference(String s, int k) {
        int n= s.length();
        int res= Integer.MIN_VALUE;

        for(char a='0';a<='4';a++){
            for(char b='0';b<='4';b++){
                if(a==b) continue;

                //for a given state , apne prev mei kaunsa minimum count_a , count_b de rakha hai
                //smallest min value of count of a - count of b 
                int[] stateMinPrev_a_b= new int[4];
                Arrays.fill(stateMinPrev_a_b,Integer.MAX_VALUE);

                //count of a and count b till index right
                int countA=0;
                int countB=0;

                //count of a and b till prev index l
                int prevA=0;
                int prevB=0;

                //now slide the window
                int l=-1,r=0;
                while(r<n){
                    countA+=(s.charAt(r)==a)?1:0;
                    countB+=(s.charAt(r)==b)?1:0;

                    //now try to shrink from l
                    while(r-l>=k && countB-prevB>=2 && countA-prevA>=1){
                        int leftState= getState(prevA,prevB);
                        stateMinPrev_a_b[leftState]=Math.min(stateMinPrev_a_b[leftState],prevA-prevB);

                        l++;
                        //ab jispe l aya hai wo bhi hatega current se
                        prevA+= (s.charAt(l)==a)?1:0;
                        prevB+= (s.charAt(l)==b)?1:0;
                    }

                    int rightState= getState(countA,countB);
                    int bestLeftState= rightState^2;

                    int bestMinDiffValueLeft= stateMinPrev_a_b[bestLeftState];

                    if(bestMinDiffValueLeft!=Integer.MAX_VALUE){
                        res= Math.max(res,(countA-countB)-bestMinDiffValueLeft);
                    }
                    r++;
                }
            }
        }
        return res;
    }
}
