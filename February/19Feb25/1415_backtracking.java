/*1415. The k-th Lexicographical String of All Happy Strings of Length n

A happy string is a string that:

1) consists only of letters of the set ['a', 'b', 'c'].
2) s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).

For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings
 "aa", "baa" and "ababbc" are not happy strings.

Given two integers n and k, consider a list of all happy strings of length n
 sorted in lexicographical order.

Return the kth string of this list or return an empty string if there are
 less than k happy strings of length n.
 
Example 1:

Input: n = 1, k = 3
Output: "c"
Explanation: The list ["a", "b", "c"] contains all happy strings of length 1. The third string is "c". */



/*APPROACH 1: TC: O(n*(3*2^(n-1)))
              SC: same
    -> generate and store all happy string in a list
    -> find the k-1 th indexed */
    class Solution1 {
        public String getHappyString(int n, int k) {
            List<String> result= new ArrayList<>();
            StringBuilder curr= new StringBuilder();
            solve(curr,result,n);
            if(result.size()<k) return "";
            return result.get(k-1);
        }
        public void solve(StringBuilder curr, List<String> result , int n){
            if(curr.length()==n) {
                result.add(curr.toString());
                return;
            }
            for(char ch='a';ch<='c';ch++){
                if(curr.length()>0 && curr.charAt(curr.length()-1)==ch)
                    continue;
                curr.append(ch); //do
                solve(curr,result,n); //explore
                curr.deleteCharAt(curr.length()-1); //undo
            }    
        }
    }
    
    /*APPRAOCH 2: SC: O(n)
    -> Instead of storing everything, we just store the last in a variable
        Since there is no call by reference concept here, we take arr[] of size 1 */
    class Solution {
        public String getHappyString(int n, int k) {
            String result[]= {""};
            int count[]={0};
            StringBuilder curr= new StringBuilder();
            solve(count,curr,result,n,k);
            return result[0];
        }
        public void solve(int count[], StringBuilder curr, String[] result , int n , int k){
            if(curr.length()==n) {
                count[0]++;
                if(count[0]==k){
                    result[0]=curr.toString();
                }
                return;
            }
            for(char ch='a';ch<='c';ch++){
                if(curr.length()>0 && curr.charAt(curr.length()-1)==ch)
                    continue;
                curr.append(ch);
                solve(count,curr,result,n,k);
                if(!result[0].isEmpty()) return;
                curr.deleteCharAt(curr.length()-1);
            }    
        }
    }