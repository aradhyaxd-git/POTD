public class 3442_maps {
    public int maxDifference(String s) {
        int freq[]= new int[26];
        for(char ch: s.toCharArray()){
            freq[ch-'a']++;
        }

        int maxi=0,mini=Integer.MAX_VALUE;
        for(int v: freq){
            if(v>0){
                if(v%2!=0) maxi=Math.max(maxi,v);
                else mini= Math.min(mini,v);
            }
        }
        return maxi-mini;
    }
}
