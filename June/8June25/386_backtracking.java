class Solution {
    /*TC: O(n) as we are visiting all numbers only once 
    It is more like dfs since we are going to the depth and then returning back*/
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res= new ArrayList<>();
        for(int startNum=1;startNum<=9;startNum++){
            solve(startNum,n,res);
        }
        return res;
    }

    public void solve(int currNum, int limit, List<Integer> res){
        if(currNum> limit) return;

        res.add(currNum);

        for(int append=0;append<=9;append++){
            int newNum= currNum*10+append;
            if(newNum>limit) return;

            solve(newNum,limit,res);
        }
    }
}