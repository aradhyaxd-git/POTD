/*1399. Count Largest Group

You are given an integer n.

Each number from 1 to n is grouped according to the sum of its digits.

Return the number of groups that have the largest size. */



class Solution {

    public int digitSum(int n){
        int sum=0;
        while(n!=0) {
            int r= n%10;
            sum +=r;
            n/=10;
        }
        return sum;
    }

    public int countLargestGroup(int n) {
        if(n<10) return n;
        int count=1;
        int maxi=0;
        HashMap<Integer,Integer> map= new HashMap<>();
        //value  sum of value
        for(int i=1;i<=n;i++){
            int x= digitSum(i);
            map.put(x,map.getOrDefault(x,0)+1);
            if(map.get(x)==maxi) count++;
            else if(map.get(x)>maxi){
                maxi=map.get(x);
                count=1;
            }
        }
        return count;

        
    }
}