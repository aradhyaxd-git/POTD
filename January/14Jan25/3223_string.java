/* THE MAIN INTUITION BEHIND THIS PROBLEM CAME FROM DRY RUN
    if I take a...a....a   -> if I put i at index1  i get   ->  a
    if I take a...a...a...a   ->    i get   ->      ..a...a

    SO the conclusion is
        when I have odd frequency, after performing all the operations
        I get a single length

        when i take even frequency, I get either 2, 
        but if freq is less than 2 , so i get the Math.min(2,freq)
    */

//Approach1 : use HashMaps
class Solution1 {
    public int minimumLength(String s) {
        HashMap<Character,Integer> map= new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int len=0;
        for(int freq: map.values()){
            if(freq%2!=0 && freq>2){
                len+=1;
            }
            else  len+= Math.min(freq,2);
        }
        return len;
    }
}


//Approach 2: use freq array
class Solution {
    public int minimumLength(String s) {
        int freq[]= new int[26];
        for(char ch: s.toCharArray()){
            freq[ch-'a']++;
        }
        int len=0;
        for(int i=0;i<26;i++){
            if(freq[i]%2!=0 && freq[i]>2)
                len+=1;
            else
                len+=Math.min(freq[i],2);
        }
        return len;
    }
}