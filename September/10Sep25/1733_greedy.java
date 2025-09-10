class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m= languages.length;

        Set<Integer>[] knows= new HashSet[m];

        for(int i=0;i<m;i++){
            knows[i]=new HashSet<>();

            for(int lang: languages[i]){
                knows[i].add(lang);
            }
        }

        Set<Integer> sadUsers= new HashSet<>();

        for(int f[]:friendships){
            int u= f[0]-1;
            int v= f[1]-1;

            boolean okay= false;


            for(int lang: knows[u]){

                if(knows[v].contains(lang)){
                    okay=true;
                    break;
                }
            }

            if(!okay){
                sadUsers.add(u);
                sadUsers.add(v);
            }
        }

        if(sadUsers.isEmpty()) return 0;


        int freq[]= new int[n+1];

        int maxFreq=0;


        for(int users:sadUsers){
            for(int lang: knows[users]){
                freq[lang]++;
                maxFreq= Math.max(maxFreq,freq[lang]);
            }
        }

        return sadUsers.size()-maxFreq;     
    }
}