/*
1980. Find Unique Binary String

Given an array of strings nums containing n unique binary strings each of length n, 
return a binary string of length n that does not appear in nums.
If there are multiple answers, you may return any of them.

Example 1:

Input: nums = ["01","10"]
Output: "11"
Explanation: "11" does not appear in nums. "00" would also be correct.
 */

 /*approach 1: Backtracking */
class Solution1 {
    public void solve(int index,int n, Set<String> set, StringBuilder s, String res[]){
        if(index==n){
            if(!set.contains(s.toString())){
                res[0]=s.toString();
            }
            return;
        }

        s.append('0');
        solve(index+1,n,set,s,res);
        if(res[0]!=null) return;
        s.deleteCharAt(s.length()-1);

        s.append('1');
        solve(index+1,n,set,s,res);
        if(res[0]!=null) return;
        s.deleteCharAt(s.length()-1);


    }
    public String findDifferentBinaryString(String[] nums) {
        int n= nums.length;
        Set<String> set=  new HashSet<>();
        for(String num:nums) set.add(num);
        StringBuilder s= new StringBuilder();
        String res[]= new String[1];
        solve(0,n,set,s,res);
        return res[0];
        
    }
}

//Approach 2: Optimal 
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n= nums.length;
        StringBuilder result= new StringBuilder();
        for(int i=0;i<n;i++){
            char ch= nums[i].charAt(i);
            result.append((ch=='0')?"1":"0"); //discarding nums[i];
        }
        return result.toString();
        
    }
}