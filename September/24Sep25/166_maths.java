class Solution {
    public String fractionToDecimal(int n, int d) {

        if(n==0) return "0";

        StringBuilder sb= new StringBuilder();

        if((long)(n)*(long)(d) <0) sb.append("-");

        long num= Math.abs((long)n);
        long den= Math.abs((long)d);

        sb.append(num/den);

        long rem= num%den;

        if(rem==0) return sb.toString();

        Map<Long,Integer> map= new HashMap<>();
        sb.append(".");


        while(rem!=0){

            if(map.containsKey(rem)){
                sb.insert(map.get(rem),"(");
                sb.append(")");
                break;
            }

            map.put(rem,sb.length());
            rem*=10;

            sb.append(rem/den);
            rem%=den;
        }
        return sb.toString();
    

        
        
    } 
}