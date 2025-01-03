//APPROACH 1 (BRUTEFORCE)
class Solution {
    public boolean isVowel(char ch) {
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') return true;
        return false;
    }
    public boolean check(String word, int start, int end) {
        char ch1 = word.charAt(start);
        char ch2 = word.charAt(end - 1); 
        return isVowel(ch1) && isVowel(ch2);
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            int startIndex = queries[i][0];
            int endIndex = queries[i][1];
            for (int j = startIndex; j <= endIndex; j++) {
                if (check(words[j], 0, words[j].length())) {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }
}


//APPROACH 2 (OPTIMAL)
class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> set= new HashSet<>(); //ek set mei daal do saare 
        set.add('a'); set.add('e'); set.add('i'); set.add('o'); set.add('u'); 
        int sum[]= new int[words.length]; int j=0; int c=0;
       for(int i=0;i<words.length;i++){
        String word= words[i];
            if(set.contains(word.charAt(0))==true && set.contains(word.charAt(word.length()-1))==true)
                c++;
            sum[i]=c;
        }
        int ans[]= new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int start= queries[i][0];
            int end= queries[i][1];
           ans[i] = sum[end] - (start > 0 ? sum[start - 1] : 0);
        }
        return ans;
    }
}