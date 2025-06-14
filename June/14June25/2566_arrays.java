class Solution {
    public int minMaxDifference(int num) {
        char original[]= String.valueOf(num).toCharArray();

        char x[]= String.valueOf(num).toCharArray();

        char maxToReplace=0;
        for(char ch: original){
            if(ch!='9'){
                maxToReplace=ch;
                break;
            }
        }

        for(int i=0;i<x.length;i++){
            if(x[i]==maxToReplace){
                x[i]='9';
            }
        }

        String maxi= new String(x);

        char y[]= String.valueOf(num).toCharArray();

        char minToReplace= y[0];
        

        for(int i=0;i<y.length;i++){
            if(y[i]==minToReplace){
                y[i]='0';
            }
        }

        String mini= new String(y);

        return Integer.parseInt(maxi)-Integer.parseInt(mini);


        
    }
}