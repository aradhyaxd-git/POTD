/*38. Count and Say

The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the run-length encoding of countAndSay(n - 1).
Run-length encoding (RLE) is a string compression method that works by replacing consecutive
identical characters (repeated 2 or more times) with the concatenation of the character and
the number marking the count of the characters (length of the run). For example, to compress
the string "3322251" we replace "33" with "23", replace "222" with "32", replace "5" with
 "15" and replace "1" with "11". Thus the compressed string becomes "23321511".

Given a positive integer n, return the nth element of the count-and-say sequence. */


class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";

        String say= countAndSay(n-1);
        StringBuilder result=new StringBuilder();

        for(int i=0;i<say.length();i++){
            char ch= say.charAt(i);
            int count=1;
            while(i<say.length()-1 && ch==say.charAt(i+1))
                {
                    i++;
                    count++;
                }
            result.append(count).append(ch);
        }
        return result.toString();
        
    }
}