class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> list= new ArrayList<>();
        int maxi[]= new int[26];
        for(String word:words2){
            int temp[]= new int[26];
            for(char x: word.toCharArray()){
                temp[x-'a']++;
                maxi[x-'a']= Math.max(temp[x-'a'],maxi[x-'a']);
            }
        }
        for(String word:words1){
            int temp[]= new int[26];
            for(char x: word.toCharArray()){
                temp[x-'a']++;
            }
            if(isSubset(temp,maxi))
                list.add(word);
        }
        return list;      
    }
    public boolean isSubset(int temp[],int maxi[]){
        for(int i=0;i<26;i++){
            if(temp[i]<maxi[i])
                return false;
        }
        return true;
    }
}