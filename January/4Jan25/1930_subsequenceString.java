//APPROACH -1 , PRE COMPUTING FREQUENCY FIRST , THEN USING A SET TO COUNT UNIQUE OCCURENCES OF STING
class Solution1 {
    public int countPalindromicSubsequence(String s) {
        int freq[]= new int[26];
        for(char ch: s.toCharArray())   
            freq[ch-'a']++;
        Set<String> set= new HashSet<>();
        boolean seen[]= new boolean[26];
        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            freq[ch-'a']--;
            for(int j=0;j<26;j++){
                if(freq[j]>0 && seen[j]){ 
                    String palindrome= "X"+(char)(j+'a')+ch+(char)(j+'a');
                    set.add(palindrome);
                }
            }
            seen[ch-'a']=true;
        }
        return set.size();
        
    }
}

//APPROACH-2 (OPTIMAL) : HERE JUST USING THE FIRST AND LAST OCCURENCE INDEX  AND COUNT EVERYTHING BETWEEN THESE INDEX
class Solution {
    public int countPalindromicSubsequence(String s) {
        int countPalindrome=0;
        for(char ch='a';ch<='z';ch++){                   //O(26)
            int first= s.indexOf(ch);
            int last= s.lastIndexOf(ch);
            Set<Character> uniqueMiddle= new HashSet<>();
            if(first!=-1 && last!=-1 && first<last){
                for(int i=first+1;i<last;i++){          //O(n)
                    uniqueMiddle.add(s.charAt(i));
                }
            }
            countPalindrome+=uniqueMiddle.size();
        }
        return countPalindrome;
        
    }
}