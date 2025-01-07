class Solution {
    public List<String> stringMatching(String[] words) {
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int n= words.length;
        Set<String> set= new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(words[j].contains(words[i]))
                    set.add(words[i]);
            }
        }
        return new ArrayList<>(set);     
    }
}
class Solution1 {
    public List<String> stringMatching(String[] words) {
        int n= words.length;
        List<String> list= new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j){
                    if(words[j].contains(words[i])){
                        if(!list.contains(words[i]))
                        list.add(words[i]);
                        else break;
                }
            }
        }
        }
        return list;
        
    }
}