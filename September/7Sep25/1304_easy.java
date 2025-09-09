class Solution1 {
    public int[] func(List<Integer>t){
        int n= t.size();
        int ans[]= new int[n];
        for(int i=0;i<n;i++){
            ans[i]=t.get(i);
        }
        return ans;

    }
    public int[] sumZero(int n) {
        List<Integer> temp= new ArrayList<>();
        int t= -(n/2);
        if(n%2==0){
            while(t<=n/2){
                if(t!=0)
                temp.add(t);
                t++;
            }
            return func(temp);   
        }
        else{
            while(t<=n/2){
                temp.add(t);
                t++;
            }
        }
        return func(temp);

        
    }
}
class Solution {
    public int[] sumZero(int n) {
        int ans[]= new int[n];

        int idx=0;

        for(int i=1;i<=n/2;i++){
            ans[idx++]=i;
            ans[idx++]=-i;
        }
        if(n%2==1){
            ans[idx]=0;
        }
        return ans;

        
    }
}