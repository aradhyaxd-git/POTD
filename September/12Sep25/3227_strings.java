class Solution {
    public boolean isVowel(char ch){
        return ch=='a'||ch=='e'||ch=='i' || ch=='o' || ch=='u';
    }
    public boolean doesAliceWin(String s) {

        for(char ch: s.toCharArray())
            if(isVowel(ch)) return true;

        return false;
    }
}