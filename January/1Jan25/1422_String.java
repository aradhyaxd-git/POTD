//BRUTE FORCE- APPRAOCH 1
class Solution2 {
    public int maxScore(String s) {
        int n= s.length();
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<=n-2;i++){
            int countZero=0;
             //iterate karke , phele find karo ki zero ka count kitna hai from 0 to i
            for(int j=0;j<=i;j++){
                if(s.charAt(j)=='0'){
                    countZero++;
                }
            }
            // dekho ki, i+1 se n-1 mei one ka count kitna hai 
            int countOne=0;
            for(int j=i+1;j<n;j++){
                if(s.charAt(j)=='1'){
                    countOne++;
                }
            }
            ans= Math.max(ans,countZero+countOne);
        }
        return ans;
        
    }
}
//APPRAOCH - 2 BETTER
class Solution1 {
    public int maxScore(String s) {
        char x[]= s.toCharArray();
        int n=x.length;
        int ans=0;
        int total1=0;
        int leftone=0,zero=0;
        for(int i=0;i<n;i++) {
            if(x[i]=='1') total1++;
        }
        for(int i=0;i<n-1;i++){
            if(x[i]=='1') leftone++;
            else zero++;
            int right_one= total1-leftone;
            ans= Math.max(ans,right_one+zero);
        }
        return ans;
    }
}


//APPROACH - 3 (OPTIMAL)
// score= Zeroes(left) + Ones(right)
// Ones(total)= Ones(left)+Ones(right)
// Ones(right)= Ones(total)-Ones(left)
// score= Zeroes(left)+  Ones(total)-Ones(left) = (Zeroes(left)-Ones(left))+Ones(total)

class Solution {
    public int maxScore(String s) {
        int result=Integer.MIN_VALUE;
        int n=s.length();
        int zero=0;
        int leftone=0;
        int i=0;
        //we have to find leftzero + rightone 
        //rightone=totalone-leftone
        //here in loop find max leftzero-leftone
        for( i=0;i<=n-2;i++)
        {
            if(s.charAt(i)=='1')
            leftone++;
            else
            zero++;
           result=Math.max(result,zero-leftone);
        }
        //after total iteration leftone becomes total one
        if(s.charAt(i)=='1')
        leftone++;
        return result+leftone;
    }
}