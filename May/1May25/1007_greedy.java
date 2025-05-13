class Solution {
    public int isPossible(int tops[],int bottoms[],int value){
        int count=0;
        for(int i=0;i<tops.length;i++){
            if(bottoms[i]==value && tops[i]==value) continue;
            if(tops[i]!=value && bottoms[i]!=value) return -1;
            if(tops[i]!=value){
                count++;
            }
        }
        return count;
    }
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n= tops.length;
        int mini=Integer.MAX_VALUE;
        for(int i=1;i<=6;i++){
            int possible1= isPossible(tops,bottoms,i);
            int possible2= isPossible(bottoms,tops,i);

            if(possible1!=-1) mini=Math.min(possible1,mini);
            if(possible2!=-1) mini=Math.min(possible2,mini);

        }
        return mini==Integer.MAX_VALUE?-1:mini;
    }
}