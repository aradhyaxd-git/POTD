class Solution {
    private long MOD= 1_000_000_007;
    public int countGoodNumbers(long n) {
        long even= (n+1)/2;
        long odd= n/2;
        long evenIndex= pow(5,even)%MOD;
        long oddIndex= pow(4,odd)%MOD;
        return (int)((evenIndex*oddIndex)%MOD);   
    }
    private long pow(long x, long n){
        if(n==0) return 1;
        long temp= pow(x,n/2);

        if(n%2==0)
            return (temp*temp)%MOD;
        else
            return (x*temp*temp)%MOD;
    }
}