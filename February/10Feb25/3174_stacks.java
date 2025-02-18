/*3174. Clear Digits

You are given a string s.

Your task is to remove all digits by doing this operation repeatedly:

Delete the first digit and the closest non-digit character to its left.
Return the resulting string after removing all digits.

Note that the operation cannot be performed on a digit that does not have any non-digit character to its left.

Example 2:

Input: s = "cb34"
Output: ""
Explanation:
First, we apply the operation on s[2], and s becomes "c4".
Then we apply the operation on s[1], and s becomes "".  */

class Solution {
    public String clearDigits(String s) {
        Stack<Character> st= new Stack<>();
        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch)){
                if(st.size()>0){
                    st.pop();
                }
            }
            else st.push(ch);
        }
        StringBuilder s1= new StringBuilder();
        while(!st.isEmpty()){
            s1.append(st.pop());
        }
        return s1.reverse().toString();
    }
}