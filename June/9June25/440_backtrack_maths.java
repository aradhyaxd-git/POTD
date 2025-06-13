class Solution1 {
    public int findKthNumber(int n, int k) {
        List<Integer> res= new ArrayList<>();
        int count=0;
        for(int startNum=1;startNum<=9;startNum++){
            solve(startNum,n,res,count,k);
        }
        return res.get(k-1);
    }

    public void solve(int currNum, int limit, List<Integer> res, int count,int k){
        if(currNum> limit) return;
        if(count==k) return;

        res.add(currNum);

        for(int append=0;append<=9;append++){
            int newNum= currNum*10+append;
            if(newNum>limit) return;

            solve(newNum,limit,res,count+1,k);
        }
    }
}

/*Now , instead of finding everything , we just want the count of the no of values in b/w 
        and inside any subtree --> us hisaab se skip krengya */

class Solution {
    private int Count(long curr, long next, long limit){
        int countNum=0;
        while(curr<=limit){
            countNum+=(next-curr);
            curr*=10;
            next*=10;


            next=Math.min(next,limit+1);
        }
        return countNum;
    }
    public int findKthNumber(int n, int k) {
        k=k-1; //since we start from the number 1
        int curr=1,next=curr+1;

        while(k>0){
            int count= Count(curr,curr+1,n);

            if(count<=k){
                curr+=1;

                k= k-count; //skip elements under curr prefix tree
            }
            else{ //neeche deep ja rhe 
                curr*=10;
                k=k-1; //root mei ja rhe hai
            }
        }
        return curr;



        
    }
}