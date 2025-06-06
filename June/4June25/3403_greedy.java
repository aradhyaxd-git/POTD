class Solution {
    String maxStr(String a, String b) {
        return a.compareTo(b)>0? a:b;
    }

    public String answerString(String word, int numFriends) {
        
        int n= word.length();
        if(numFriends==1) return word;
        int longestPossible=n-(numFriends-1);
        String res="";

        for(int i=0;i<n;i++){
            int takePossibleLength= Math.min(longestPossible,n-i);
            res =maxStr(res,word.substring(i,i+takePossibleLength));

        }
        return res;
    }
}