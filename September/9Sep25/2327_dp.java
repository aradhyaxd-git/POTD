//APPROACH 1
class Solution {
    int n;
    int delay;
    int forget;
    final int mod=1_000_000_007;
    Long dp[];
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        this.n=n;
        this.delay=delay;
        this.forget=forget;
        dp= new Long[n+1];
        return (int)solve(1)%mod;
    }
    public long solve(int day){
        if(day>n) return 0;

        if(dp[day]!=null) return dp[day];

        long ans =(day+forget>n)?1:0;



        for(int nextDay=day+delay; nextDay<day+forget && nextDay<=n; nextDay++){
            ans+= (solve(nextDay)%mod);
        }

        return dp[day]=ans%mod;
    }
}