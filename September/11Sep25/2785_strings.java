class Solution {
    public boolean isVowel(char ch){
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='E'||ch=='A'||ch=='I'||ch=='O'||ch=='U';
    }
    public String sortVowels(String s) {
        StringBuilder st= new StringBuilder(s);
        List<Character> lst= new ArrayList<>();
        List<Integer> idx= new ArrayList<>();

        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            if(isVowel(ch)){
                idx.add(i);
                lst.add(ch);
            }
        }

        Collections.sort(lst);

        for(int i=0;i<idx.size();i++){
            int index= idx.get(i);
            st.setCharAt(index,lst.get(i));
        }
        return st.toString();    
    }
}