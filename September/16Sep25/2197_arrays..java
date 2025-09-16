class Solution {
    public int findGcd(int a, int b){
        if(b==0) return a;

        return findGcd(b,a%b);
    }
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> res= new ArrayList<>();
        for(int num:nums){

            while(!res.isEmpty()){

                int prev= res.get(res.size()-1);

                int gcd= findGcd(num,prev);

                if(gcd<=1) break;
                res.remove(res.size()-1);

                num=(int)((long)num*prev/gcd);
            }
            res.add(num);
        }
        return res;
        
    }
}