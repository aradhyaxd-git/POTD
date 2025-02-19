/*2698. Find the Punishment Number of an Integer

Given a positive integer n, return the punishment number of n.

The punishment number of n is defined as the sum of the squares of all integers i such that:

1 <= i <= n
The decimal representation of i * i can be partitioned into contiguous substrings 
such that the sum of the integer values of these substrings equals i.

Example 1:

Input: n = 10
Output: 182
Explanation: There are exactly 3 integers i in the range [1, 10] that satisfy the conditions in the statement:
- 1 since 1 * 1 = 1
- 9 since 9 * 9 = 81 and 81 can be partitioned into 8 and 1 with a sum equal to 8 + 1 == 9.
- 10 since 10 * 10 = 100 and 100 can be partitioned into 10 and 0 with a sum equal to 10 + 0 == 10.
Hence, the punishment number of 10 is 1 + 81 + 100 = 182
*/

/*Approach 1: using Backtracking*/
class Solution2 {
    public int punishmentNumber(int n) {
        int punishment=0;
        for(int i=1;i<=n;i++){
            int sq= i*i;
            String s= Integer.toString(sq);
            if(check(0,0,s,i)){
                punishment+=sq;
            }
        }
        return punishment;
    }

    public boolean check(int i, int currSum, String s, int num){
        if(i==s.length()) return currSum==num;

        if(currSum>num) return false;

        boolean possible = false;

        for(int j=i;j<s.length();j++){
            String sub= s.substring(i,j+1);
            int val= Integer.parseInt(sub);
            if(currSum+val > num) break;
            if(check(j+1,currSum+val,s,num)) return true;
        }
        return false;
    }
}

/*approach2: recursion+memoization */
class Solution1 {
    public int punishmentNumber(int n) {
        int punishment=0;
        for(int i=1;i<=n;i++){
            int sq= i*i;
            String s= Integer.toString(sq);
            int dp[][]= new int[s.length()][i+1];
            for(int row[]:dp) Arrays.fill(row,-1);
            if(check(0,0,s,i,dp)){
                punishment+=sq;
            }
        }
        return punishment;
    }

    public boolean check(int i, int currSum, String s, int num,int dp[][]){
        if(i==s.length()) return currSum==num;
        if(dp[i][currSum] != -1) return dp[i][currSum]==1;
        
        if(currSum>num) return false;
        
        boolean possible=false;
        for (int j = i; j < s.length(); j++) {
            String currentString = s.substring(i, j + 1);
            int addend = Integer.parseInt(currentString);
            if (currSum + addend > num) break;
            possible = check(j+1,currSum+addend,s,num,dp);
            if (possible==true){
                dp[i][currSum]=1;
                return true;
            }
        }
        dp[i][currSum]=0;
        return false;
    }
}


//Approach 3: Most Optimal (imp)
class Solution {

    public boolean check (int sq, int currSum, int num){
        if(sq==0) return currSum==num;

        return check(sq/10,currSum+sq%10,num) 
        || check(sq/100,currSum+sq%100, num) 
        || check(sq/1000,currSum+sq%1000,num)
        || check(sq/10000,currSum+sq%10000, num);
    }
    public int punishmentNumber(int n) {
        int punishment=0;
        for(int i=1;i<=n;i++){
            int sq= i*i;
            if(check(sq,0,i)){
                punishment+=sq;
            }
        }
        return punishment;
        
    }
}