class Solution {
    public boolean canConstruct(String s, int k) {
        int n= s.length();
        //base case1
        if(n==k) return true;
        //base case2 
        if(n<k) return false;
        int freq[]= new int[26];
        int oddFreqCount=0;
        for(char x: s.toCharArray()){
            freq[x-'a']++;
        }
        for(int i=0;i<26;i++){
            if(freq[i]%2!=0)
                oddFreqCount++;
        }
        return oddFreqCount<=k?true:false;   
    }
}
class Solution1 {
    public boolean canConstruct(String s, int k) {
        int n= s.length();
        //base case1
        if(n==k) return true;
        //base case2 
        if(n<k) return false;
        int oddCount=0;
        for(char x:s.toCharArray()){
            int position= x-'a';
            int mask= 1<<position;
            oddCount^=mask;
        }
        return Integer.bitCount(oddCount)<=k;
    }
}