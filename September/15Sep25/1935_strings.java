class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {

        String s[]=text.split(" ");
        Set<Character> set= new HashSet<>();
        for(char ch: brokenLetters.toCharArray()) set.add(ch);

        int count=0;

        for(String t: s){
            boolean flag=false;

            for(char ch: t.toCharArray()){
                if(set.contains(ch)) {
                    flag=true;
                    break;
                }
            }

            if(!flag) count++;
        

        }
        return count;
        
    }
}