class Solution {
    public int check(String s){
        int sum=0;
        int number= Integer.parseInt(s);
        while(number!=0){
            sum+= number%10;
            number=number/10;
        }
        return sum;
    }
    public int solve(StringBuilder s){
        if(s.length()%2!=0) return 0;
        int  n= s.length();
        String part1= s.substring(0,n/2);
        String part2= s.substring(n/2,n);
        return check(part1)==check(part2)?1:0;
    }
    public int countSymmetricIntegers(int low, int high) {
        int count=0;
        for(int i=low;i<=high;i++){  
            StringBuilder st= new StringBuilder(String.valueOf(i));
            count+= solve(st);
        }
        return count;

        
    }
}