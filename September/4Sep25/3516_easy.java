class Solution {
    public int findClosest(int x, int y, int z) {
        int r1=Math.abs(z-x);
        int r2= Math.abs(z-y);

        if(r1==r2) return 0;

        return r1>r2?2:1;
        
    }
}